package model;

public class IsValidFileLogic {
	public boolean execute(String name) {
		if(name != null) {
			String[] perms = {"jpg", "jpeg", "png"};
			String[] names = name.split("\\.");
			for(String perm: perms) {
				if(perm.contentEquals(names[names.length - 1])) {
					return true;
				}
			}
		}
		return false;
	}
}
