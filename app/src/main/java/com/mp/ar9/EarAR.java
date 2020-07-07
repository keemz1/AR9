package com.mp.ar9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.NavigationMenu;
import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.animation.ModelAnimator;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import io.github.yavski.fabspeeddial.FabSpeedDial;

public class EarAR extends AppCompatActivity {
    private ArFragment arFragment;
    private AnchorNode anchorNode;
    private ModelAnimator animator;
    private int nextAnimation;
    private FloatingActionButton btn_anim;
    private ModelRenderable earAR;
    private TransformableNode transformableNode;
    private boolean active = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ear_ar);

        //Floating Action
        FabSpeedDial fabSpeedDial = (FabSpeedDial) findViewById(R.id.btn_anim);
        fabSpeedDial.setMenuListener(new FabSpeedDial.MenuListener() {
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                return true;
            }

            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                GetARInfo arInfo = new GetARInfo();
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        Intent intent = new Intent(EarAR.this, ARMainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_info:
                        if (active) {
                            Intent info = new Intent(EarAR.this, GetARInfo.class);
                            info.putExtra("picture", R.drawable.human_ear_diagram);
                            startActivity(info);
                        }
                        break;
                }
                return true;
            }

            @Override
            public void onMenuClosed() {

            }
        });

        setupModel();

        arFragment = (ArFragment) getSupportFragmentManager()
                .findFragmentById(R.id.sceneform_Earfragment);
        //Tap on plane event
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                if (earAR == null)
                    return;
                //Create the Anchor
                Anchor anchor = hitResult.createAnchor();
                //if the object is in place on the plane
                if (anchorNode == null) {
                    anchorNode = new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());

                    transformableNode = new TransformableNode(arFragment.getTransformationSystem());
                    //Scale Model
                    transformableNode.getScaleController().setMinScale(15.09f);
                    transformableNode.getScaleController().setMaxScale(15.1f);
                    transformableNode.setParent(anchorNode);
                    transformableNode.setRenderable(earAR);

                }
            }
        });
    }

    private void setupModel() {
        ModelRenderable.builder()
                .setSource(this, R.raw.ear_canal)
                .build()
                .thenAccept(renderable -> earAR = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    return null;
                });
    }
}
