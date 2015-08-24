package com.baru.survivor.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.baru.survivor.backend.Status;

public class Survivors extends ApplicationAdapter {
	
	Status status = new Status();
	UI ui = new UI();
	public static final int width = 48;
	public static final int height = 25;
	public static final int tileSize = 32;
	public static final String spriteSheet = "spriteSheet-big.png";
	public static final float speed = 1;
	
	@Override
	public void create () {
		status.create();
		ui.create(status);
	}

	public void dispose(){
		ui.dispose();
	}
	
	@Override
	public void render () {
		status.nextState();
		ui.render(status);
	}
}
