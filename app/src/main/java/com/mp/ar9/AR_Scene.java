package com.mp.ar9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationView;
import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import io.github.yavski.fabspeeddial.FabSpeedDial;

public class AR_Scene extends AppCompatActivity /*implements NavigationView.OnNavigationItemSelectedListener*/ {
    TextView textView;
    ImageView imageView;
    private int selected = 0;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    private ArFragment arFragment;
    private AnchorNode anchorNode;
    //private int next
    private ModelRenderable arImage;

    private ModelRenderable skullRenderable,
            heartRenderable,
            plantCellRenderable,
            humanCellRenderable,
            nervesRenderable,
            brainRenderable,
            eyeRenderable,
            earCanalRenderable;

    //ImageView skull, heart, plantCell, humanCell, lungs, ear, eye;
    //View arrayView[];
    ViewRenderable viewRenderable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar_scene);
    }


        //Navigation Menu Code
        /*drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbarArScene);

        //Toolbar
        setSupportActionBar(toolbar);

        //Navigation Drawer Menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        setModel();

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_scene);
        //Tap on Plane Event
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {


                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());
                createModel(anchorNode, selected);
            }
        });


        FabSpeedDial fabSpeedDial = findViewById(R.id.btn_anim);
        fabSpeedDial.setMenuListener(new FabSpeedDial.MenuListener() {
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                return true;
            }

            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                Toast.makeText(AR_Scene.this, "AR Image Unable to Load" + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public void onMenuClosed() {

            }
        });
    }

    private void setModel() {

        ModelRenderable.builder()
                .setSource(this, R.raw.human_cell)
                .build()
                .thenAccept(renderable -> humanCellRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, R.raw.brain)
                .build()
                .thenAccept(renderable -> brainRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, R.raw.ear_canal)
                .build()
                .thenAccept(renderable -> earCanalRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, R.raw.human_eye)
                .build()
                .thenAccept(renderable -> eyeRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, R.raw.heart2)
                .build()
                .thenAccept(renderable -> heartRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, R.raw.nerve_cell)
                .build()
                .thenAccept(renderable -> nervesRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, R.raw.plant_cell)
                .build()
                .thenAccept(renderable -> plantCellRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    return null;
                });
    }

    public void createModel(AnchorNode anchorNode, int selected) {

        TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
        int selectedAR = getSelected();
        if (arImage == null) {
            return;
        }
        if (selectedAR == 1) {
            //Scale Model
            transformableNode.getScaleController().setMaxScale(5.09f);
            transformableNode.getScaleController().setMaxScale(5.1f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(humanCellRenderable);
        }
        if (selectedAR == 2) {
            transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            //Scale Model
            transformableNode.getScaleController().setMaxScale(0.09f);
            transformableNode.getScaleController().setMaxScale(0.1f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(brainRenderable);
        }
        if (selectedAR == 3) {
            transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            //Scale Model
            transformableNode.getScaleController().setMaxScale(0.09f);
            transformableNode.getScaleController().setMaxScale(0.1f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(earCanalRenderable);
        }
        if (selectedAR == 4) {
            transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            //Scale Model
            transformableNode.getScaleController().setMaxScale(0.09f);
            transformableNode.getScaleController().setMaxScale(0.1f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(eyeRenderable);
        }
        if (selectedAR == 5) {
            transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            //Scale Model
            transformableNode.getScaleController().setMaxScale(0.09f);
            transformableNode.getScaleController().setMaxScale(0.1f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(heartRenderable);
        }
        if (selectedAR == 6) {
            transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            //Scale Model
            transformableNode.getScaleController().setMaxScale(0.09f);
            transformableNode.getScaleController().setMaxScale(0.1f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(nervesRenderable);
        }
        if (selectedAR == 7) {
            transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            //Scale Model
            transformableNode.getScaleController().setMaxScale(0.09f);
            transformableNode.getScaleController().setMaxScale(0.1f);
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(plantCellRenderable);

        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            onBackPressed();
        }
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_animalcell:

                selected = 1;
                break;
            case R.id.nav_brain:
                selected = 2;
                break;
            case R.id.nav_ear:
                selected = 3;
                break;
            case R.id.nav_eye:
                selected = 4;
                break;
            case R.id.nav_heart:
                selected = 5;
                break;
            case R.id.nav_nerve:
                selected = 6;
                break;
            case R.id.nav_plantcell:
                selected = 7;
                break;
        }
        setSelected(selected);
        return true;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }*/

}
