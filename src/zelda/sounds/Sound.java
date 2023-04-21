package zelda.sounds;

public enum Sound {
	RUBY("res/sounds/LOZ_Get_Rupee.wav"),
    HIT("res/sounds/LOZ_Hit.wav"),
    HURT("res/sounds/LOZ_Hurt.wav"),
    FANFARE("res/sounds/LOZ_Fanfare.wav"),
    HEART("res/sounds/LOZ_Get_Heart.wav"),
    DIE("res/sounds/LOZ_Die.wav"),
	MUSIC("res/sounds/son_jeu.wav");
	
	
	private String imagePath;

    Sound(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}