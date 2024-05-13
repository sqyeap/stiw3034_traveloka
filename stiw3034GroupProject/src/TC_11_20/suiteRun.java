package TC_11_20;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import TC_01_10.Tc01_regisEmail;
import TC_01_10.Tc02_regisInvalidValidCode;
import TC_01_10.Tc03_regisValidCode;
import TC_01_10.Tc04_regisInvalidPassword;
import TC_01_10.Tc05_RegisValidPassword;
import TC_01_10.Tc06_loginInvalidPassword;
import TC_01_10.Tc07_loginValidPassword;
import TC_01_10.Tc08_NavigateTwitter;
import TC_01_10.Tc09_NavigateTikTok;
import TC_01_10.Tc10_NavigateYouTube;
import TC_21_30.TC_21_Browse_Hotel_Reviews;
import TC_21_30.TC_22_Filter_By_Category;
import TC_21_30.TC_23_Filter_With_Media;
import TC_21_30.TC_24_Filter_By_Score;
import TC_21_30.TC_25_Reset_Filter;
import TC_21_30.TC_26_Download_From_Play_Store;
import TC_21_30.TC_27_Download_From_App_Store;
import TC_21_30.TC_28_Contact_Using_Telegram;
import TC_21_30.TC_29_Change_Language;
import TC_21_30.TC_30_Sort_By_Price;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	
	// Group	: 8
	// Members	: Woon Zhun Ping 279144
	// 			  Wong Zi Qing	 279199
	//			  Yeap Shu Qi	 280038
	
	// Wong Zi Qing 279199
	Tc01_regisEmail.class,
	Tc02_regisInvalidValidCode.class,
	Tc03_regisValidCode.class,
	Tc04_regisInvalidPassword.class,
	Tc05_RegisValidPassword.class,
	Tc06_loginInvalidPassword.class,
	Tc07_loginValidPassword.class,
	Tc08_NavigateTwitter.class,
	Tc09_NavigateTikTok.class,
	Tc10_NavigateYouTube.class,
	
	// Woon Zhun Ping 279144
	TC_11_searchCityHotel.class,
	TC_12_searchFlight.class,
	TC_13_searchFlight_CabinClass.class,
	TC_14_searchFlightHotel_Valid.class,
	TC_15_searchFlightHotel_Invalid.class,
	TC_16_fliterRating.class,
	TC_17_fliterFacilities.class,
	TC_18_fliterInvalid.class,
	TC_19_searchActivites_Valid.class,
	TC_20_searchActivites_Invalid.class,
	
	// Yeap Shu Qi 280038
	TC_21_Browse_Hotel_Reviews.class,
	TC_22_Filter_By_Category.class,
	TC_23_Filter_With_Media.class,
	TC_24_Filter_By_Score.class,
	TC_25_Reset_Filter.class,
	TC_26_Download_From_Play_Store.class,
	TC_27_Download_From_App_Store.class,
	TC_28_Contact_Using_Telegram.class,
	TC_29_Change_Language.class,
	TC_30_Sort_By_Price.class
	
})

public class suiteRun {


}


