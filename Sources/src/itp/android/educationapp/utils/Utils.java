package itp.android.educationapp.utils;

import itp.android.educationapp.model.Education;
import itp.android.educationapp.model.Help;

public class Utils {
	static Education edu;
	static Help h;
	public static void saveDanhSachTruongModel(Education education){
		edu = education;
	}
	
	public static Education getDanhSachTruongModel(){
		return edu;
	}
	
	public static void saveTuVanModel(Help help){
		h = help;
	}
	
	public static Help getTuVanModel(){
		return h;
	}
}
