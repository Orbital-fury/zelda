package zelda.sounds;

public enum Sound {
	RUBY("res/sounds/LOZ_Get_Rupee.wav"),
    SWORD("res/sprites/Objects/OYP.gif"),
    FANFARE("res/sounds/LOZ_Fanfare.wav");
	
	private String imagePath;

    Sound(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}