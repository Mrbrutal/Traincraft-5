package train.common.library;

import java.lang.reflect.InvocationTargetException;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import train.common.api.AbstractTrains;
import train.common.entity.rollingStock.*;

public enum EnumTrains {
	
	/** Passengers */
	passengerCartBlue("Passenger Blue",EntityPassengerBlue.class, 48,ItemIDs.minecartPassengerBlue.item,"train_passenger_3","passenger",0,0,0.9,0,0,0,0,0,0,new String[] {"Blue","Red","Green"},18, null,null,0.98,1.98),
	passengerCartBlackSmall("Passenger Small Black",EntityPassenger2.class, 27,ItemIDs.minecartPassenger2.item,"train_passenger_1","passenger",0,0,0.1,0,0,0,0,0,0,null,18,null,null,0.98,1.98),
	passengerLongGreen("Passenger Green Long",EntityPassenger5.class, 45,ItemIDs.minecartPassenger5.item,"train_passenger_2","passenger",0,0,0.6,0,0,0,0,0,0,null,18,null,null,0.98,1.98),
	passengerShortGreen("Passenger Short Green",EntityPassenger7.class, 86,ItemIDs.minecartPassenger7.item,"train_passenger_4","passenger",0,0,0.5,0,0,0,0,0,0,null,18,null,null,0.98,1.98),
	passenger_1class_DB("Passenger 1Class DB",EntityPassenger_1class_DB.class, 106,ItemIDs.minecartPassenger8_1class_DB.item,"train_passenger_5","passenger",0,0,1.5,0,0,0,0,0,0,null,18,null,null,0.98,1.98),
	passenger_2class_DB("Passenger 2Class DB",EntityPassenger_2class_DB.class, 107,ItemIDs.minecartPassenger9_2class_DB.item,"train_passenger_6","passenger",0,0,1,0,0,0,0,0,0,null,18,null,null,0.98,1.98),
	passengerHighSpeedZeroED("Passenger High Speed Zero ED",EntityPassengerHighSpeedCarZeroED.class, 37,ItemIDs.minecartPassengerHighSpeedCarZeroED.item,"train_high_speed_cart_zeroed","passenger",0,0,2,0,0,0,0,0,0,null,18,null,null,0.98,1.98),
	passengerTramNY("Passenger Tram NY",EntityPassengerTramNY.class, 55,ItemIDs.minecartPassengerTramNY.item,"train_tram_ny","passenger",0,0,1,0,0,0,0,0,0,null,18,null,null,0.98,1.98),
	passengerAdler("Passenger Adler",EntityPassengerAdler.class, 95,ItemIDs.minecartPassengerAdler.item,"train_passenger_adler","passenger",0,0,1,0,0,0,0,0,0,null,18,null,null,0.98,1.98),
	//passengerDBOriental("pass_DB_oriental",EntityPassengerDBOriental.class, 56,ItemIDs.minecartPassengerDBOriental.item,"train_tram_ny","passenger",0,0,1,0,0,0,0,0,0,null,18,null,null,0.98,1.98),
	
	/** Caboose */
	cabooseRed("Caboose Red",EntityCaboose.class, 85,ItemIDs.minecartCaboose.item,"train_caboose","caboose",0,0,0.5,0,0,0,0,0,0,null,18,null,null,0.98,1.98),
	cabooseBlack("Caboose Black",EntityCaboose3.class, 1,ItemIDs.minecartCaboose3.item,"train_caboose_2","caboose",0,0,0.5,0,0,0,0,0,0,null,18,null,null,0.98,1.98),

	/** Specials **/
	stockCar("Stock Cart",EntityStockCar.class, 44,ItemIDs.minecartStockCar.item,"train_stock","special",0,0,2,0,0,0,0,0,0,null,18,null,null,0.98,1.98),
	workCart("Work Cart Yellow",EntityWorkCart.class,29,ItemIDs.minecartWork.item,"train_work","work",0,0,0.7,0,0,0,0,0,0,null,18,null,null,0.98,1.98),
	flatCart("Flat Cart",EntityFlatCart.class, 35,ItemIDs.minecartFlatCart.item,"train_flat","flat",0,0,0.2,0,0,0,0,0,0,null,18,null,null,0.98,0.3),
	workCaboose("Work Caboose",EntityCabooseWorkCart.class, 43,ItemIDs.minecartCabooseWork.item,"train_caboose_work","work",0,0,0.6,0,0,0,0,0,0,null,18,null,null,0.98,1.98),
	cabooseLogging("Caboose Logging",EntityCabooseLogging.class, 99,ItemIDs.minecartCabooseLogging.item,"train_logging_caboose","work",0,0,0.2,0,0,0,0,0,0,null,18,null,null,0.98,1.98),
	mailWagen_DB("Mail Wagon DB",EntityMailWagen_DB.class, 105,ItemIDs.minecartMailWagon_DB.item,"train_mail","work",0,0,1,0,0,0,0,0,0,null,18,null,null,0.98,1.98),
	jukeBoxCart("JukeBox Cart",EntityJukeBoxCart.class, 42,ItemIDs.minecartJukeBoxCart.item,"train_jukebox","special",0,0,0.2,0,0,0,0,0,0,null,18,null,null,0.98,0.5),
	flatCartSU("Flat Cart SU",EntityFlatCartSU.class, 60,ItemIDs.minecartFlatCartSU.item,"train_flat_su","flat",0,0,0.2,0,0,0,0,0,0,null,18,null,null,0.98,0.3),
	flatCartUS("Flat Cart US",EntityFlatCartUS.class, 68,ItemIDs.minecartFlatCartUS.item,"train_flat_us","flat",0,0,0.4,0,0,0,0,0,0,null,18,null,null,0.98,0.3),
	tracksBuilder("Tracks Builder",EntityTracksBuilder.class, 28,ItemIDs.minecartBuilder.item,"train_builder","special",0,0,0,0,0,0,0,0,0,null,14,null,null,0.98,1.98),
	flatCar_DB("Flat Cart DB",EntityFlatCar_DB.class, 109,ItemIDs.minecartFlatCart_DB.item,"train_flat_db","flat",0,0,0.2,0,0,0,0,0,0,null,18,null,null,0.98,0.3),

	/** Freight */
	freightCartRed("Freight Cart Red",EntityFreightCart2.class, 41,ItemIDs.minecartFreightCart2.item,"train_freight_2","freight",3,null,18,0.98,1.98,36,new String[] {"Cargo: any"}),
	freightCartYellow("Freight Cart Yellow",EntityFreightCart.class, 2,ItemIDs.minecartChest.item,"train_freight_1","freight",3,null,18,0.98,1.98,36,new String[] {"Cargo: any"}),
	freightWood("Freight Flat Cart Log",EntityFreightWood.class, 6,ItemIDs.minecartWood.item,"train_transport_wood","freight",3,null,18,0.98,0.98,27,new String[] {"Cargo: only Logs"}),
	freightHopper("Freight Hopper Green",EntityFreightGrain.class, 3,ItemIDs.minecartGrain.item,"train_hopper_grain","freight",4,null,18,0.98,1.98, 36,new String[] {"Cargo: wheat, seeds"}),
	freightOpenWagon("Freight Open Wagon",EntityFreightOpenWagon.class,38,ItemIDs.minecartOpenWagon.item,"train_hopper","freight",2,null,18,0.98,0.98,36,new String[] {"Cargo: blocks, vanilla items"}),//"train_hopper" for open wagon => weird
	//passenger4(EntityPassenger4.class, ,null,null,0.98,0.98),//apparently has been removed
	freightHopperUS("Freight Hopper US",EntityFreightHopperUS.class, 71,ItemIDs.minecartFreightHopperUS.item, "train_hopper_us","freight",4,null,18,0.98,1.98, 27, new String[] {"Cargo: blocks"}),
	flatCartWoodUS("Freight Flat Cart Wood US",EntityFlatCartWoodUS.class, 69,ItemIDs.minecartFlatCartWoodUS.item,"train_flat_wood","freight",3,null,18,0.98,0.98, 27,new String[] {"Cargo: only planks"}),
	freightCartUS("Freight Cart US",EntityFreightCartUS.class, 66,ItemIDs.minecartFreightCartUS.item,"train_freight_3","freight",3.5,null,18,0.98,0.98,36,new String[] {"Cargo: blocks, vanilla items"}),
	freightBoxCartUS("Freight Box Cart US",EntityBoxCartUS.class, 67,ItemIDs.minecartBoxCartUS.item,"train_box_us","freight",2,null,18,0.98,1.98,45,new String[] {"Cargo: any"}),
	freightCartSmall("Freight Cart Small",EntityFreightCartSmall.class, 72,ItemIDs.minecartFreightCartSmall.item,"train_freight_4","freight",1,null,18,0.98,0.98,36,new String[] {"Cargo: any"}),
	freightMinetrain("Freight Minecart Yellow",EntityFreightMinetrain.class, 76,ItemIDs.minecartMineTrain.item,"train_mine_cart","freight",0.5,null,18,0.98,0.98, 18,new String[] {"Cargo: opaque blocks"}),
	flatCartWoodLogs("Freight Flat Logs",EntityFreightWood2.class, 84,ItemIDs.minecartFreightWood2.item,"train_transport_wood_2","freight",3,null,18,0.98,0.98,18,new String[] {"Cargo: only logs"}),
	freightClosedRedBrown("Freight Cart Closed RedBrown",EntityFreightClosed.class, 87,ItemIDs.minecartFreightClosed.item,"train_freight_closed","freight",2.5,null,18,0.98,1.98,36,new String[] {"Cargo: any"}),
	freightOpenRedBrown("Freight Open RedBrown",EntityFreightOpen2.class, 88,ItemIDs.minecartFreightOpen2.item,"train_freight_open","freight",5,null,18,0.98,0.98,21,new String[] {"Cargo: any"}),
	freightWagen_DB("Freight Wagon DB",EntityFreightWagenDB.class, 104,ItemIDs.minecartFreightWagon_DB.item,"train_freight_db","freight",4,null,18,0.98,1.98, 54,new String[] {"Cargo: any"}),
	flatCarRails_DB("Freight Flat Cart Rails DB",EntityFlatCarRails_DB.class, 108,ItemIDs.minecartFlatCartRail_DB.item,"train_transport_rail","freight",5,null,18,0.98,0.98, 36,new String[] {"Cargo: only rails"}),
	flatCarLogs_DB("Freight Flat Cart Logs DB",EntityFlatCarLogs_DB.class,110,ItemIDs.minecartFlatCartLogs_DB.item,"train_transport_wood_3","freight",4,null,18,0.98,0.98,45,new String[] {"Cargo: only logs"}),
	freightGondola_DB("Freight Gondola DB",EntityFreightGondola_DB.class,114,ItemIDs.minecartFreightGondola_DB.item,"train_freight_gondola","freight",3.5,null,18,0.98,0.98,45,new String[] {"Cargo: blocks, vanilla items"}),
	freightCenterBeam_Empty("Freight Center Beam Empty",EntityFreightCenterbeam_Empty.class, 15,ItemIDs.minecartFreightCenterBeam_Empty.item,"train_freight_empty","freight",0.5,null,18,0.98,1.98,54,new String[] {"Cargo: any"}),
	freightCenterBeam_Wood1("Freight Center Beam Wood1",EntityFreightCenterbeam_Wood_1.class, 16,ItemIDs.minecartFreightCenterBeam_Wood_1.item,"train_freight_wood_1","freight",3,null,18,0.98,1.98,54,new String[] {"Cargo: wood stuff"}),
	freightCenterBeam_Wood2("Freight Center Beam Wood2", EntityFreightCenterbeam_Wood_2.class, 17,
			ItemIDs.minecartFreightCenterBeam_Wood_2.item, "train_freight_wood_2", "freight", 3, null, 18, 0.98, 1.98,
			54, new String[] { "Cargo: wood stuff" }),
	freightWellcar("Freight Well Car",EntityFreightWellcar.class, 20,ItemIDs.minecartFreightWellcar.item,"train_freight_wellcar","freight",3,new String[] {"Blue","Red","Green","LightGrey","Grey"},18,0.98,1.98,54,new String[] {"Cargo: any"}),
	freightTrailer("Freight Trailer",EntityFreightTrailer.class, 18,ItemIDs.minecartFreightTrailer.item,"train_freight_trailer","freight",3,new String[] {"Blue","Yellow","LightBlue","Red","Grey"},18,0.98,1.98,54,new String[] {"Cargo: any"}),

	/** Tanks **/
	tankWagon_DB("Tank Wagon DB",EntityTankWagon_DB.class, 115,ItemIDs.minecartTankWagon_DB.item,"train_tank_db","tank",0,0,6,0,0,0,0,0,50000,null,18,null,null,0.98,1.98,new String[] {"Capacity: 50000mb"}),
	tankWagonUS("Tank Wagon US",EntityTankWagonUS.class, 70,ItemIDs.minecartTankWagonUS.item,"train_tank_us_2","tank",0,0,6,0,0,0,0,0,70000,null,18,null,null,0.98,1.98,new String[] {"Capacity: 70000mb"}),
	tankWagonGrey("Tank Wagon Grey",EntityTankWagon2.class,47,ItemIDs.minecartTankWagon2.item,"train_tank_blue","tank",0,0,3,0,0,0,0,0,40000,null,18,null,null,0.98,1.98,new String[] {"Capacity: 40000mb"}),
	tankCartLava("Tank Lava",EntityTankLava.class, 5,ItemIDs.minecartWatertransp.item,"train_tank_lava","tank",0,0,5,0,0,0,0,0,30000,new String[] {"Empty","Full"},18,null,null,0.98,1.98,new String[] {"Capacity: 30000mb","Only lava"}),
	tankWagonYellow("Tank Wagon Yellow",EntityTankWagon.class, 39,ItemIDs.minecartTankWagon.item,"train_tank_us","tank",0,0,6,0,0,0,0,0,40000,null,18,null,null,0.98,1.98,new String[] {"Capacity: 40000mb"}),

	/** Tenders */
	tenderSmall("Tender Small Black",EntityTenderSmall.class, 4,ItemIDs.minecartTender.item,"train_tender","tender",0,0,0.1,0,0,0,0,0,5000,new String[]{"Black","Red","Blue","Green","Yellow"},18,null,null,0.98,0.98,new String[] {"Water capacity: 5000mb"}),
	//tenderHeavy("Tender Heavy",EntityTenderHeavy.class, 34,ItemIDs.minecartTenderHeavy.item,"train_tender_heavy","tender",0,0,2,0,0,0,0,0,14000,null,18,null,null,0.98,1.98,new String[] {"Water capacity: 14000mb"}),
	tender4_4_0("Tender 4-4-0 Red",EntityTender4_4_0.class, 83,ItemIDs.minecartSteamRedTender.item,"train_tender_steam","tender",0,0,0.2,0,0,0,0,0,8000,new String[] {"Black","White","Brown","Blue","Green","Red"},18,null,null,0.98,0.98,new String[] {"Water capacity: 8000mb"}),
	tenderA4("Tender A4 Mallard",EntityTenderA4.class, 54,ItemIDs.minecartLocoA4MallardTender.item,"train_tender_a4","tender",0,0,0.2,0,0,0,0,0,6000,new String[] {"Blue", "Yellow", "Black", "Green", "White"},18,null,null,0.98,0.98,new String[] {"Water capacity: 6000mb"}),
	tenderBR01("Tender BR01",EntityTenderBR01_DB.class, 103,ItemIDs.minecartTenderBR01_DB.item,"train_tender_br01","tender",0,0,0.5,0,0,0,0,0,20000,null,18,null,null,0.98,1.98,new String[] {"Water capacity: 20000mb"}),
	tenderEr_Ussr("Tender ER_USSR",EntityTenderEr_Ussr.class, 9,ItemIDs.minecartTenderEr.item,"train_tender_ussr","tender",0,0,2,0,0,0,0,0,16000,null,18,null,null,0.98,1.98,new String[] {"Water capacity: 16000mb"}),
	tenderC62Class("Tender C62Class",EntityTenderC62Class.class, 119,ItemIDs.minecartTenderC62Class.item,"train_tender_c62_class","tender",0,0,0.5,0,0,0,0,0,14000,null,18,null,null,0.98,1.98,new String[] {"Water capacity: 14000mb"}),
	tenderAdler("Tender Adler",EntityTenderAdler.class, 96,ItemIDs.minecartTenderAdler.item,"tender_adler","tender",0,0,0.5,0,0,0,0,0,4000,null,18,null,null,0.98,1.98,new String[] {"Water capacity: 4000mb"}),

	/** Diesel */
	locoDieselKOF("Loco Diesel KOF DB",EntityLocoDieselKof_DB.class,25,ItemIDs.minecartKof_DB.item, "train_kof","diesel",350,57,0,60,0,170,0.66,0.96,5000,new String[] {"Red","Green","Yellow","Black","Blue"},17,new double[]{-1.6},null,0.98,0.98),
	locoDieselGP40("Loco Diesel CD742",EntityLocoDieselCD742.class, 62,ItemIDs.minecartCD742.item,"train_gp40","diesel",850,70,0,50,0,250,0.8,0.966,10000,new String[] {"Yellow","White"},15,new double[]{-1.4},null,0.98,1.98),
	locoDieselChME3("Loco Diesel ChME3", EntityLocoDieselChME3.class, 32, ItemIDs.minecartChmE3.item, "train_chme3",
			"diesel", 500, 95, 0, 60, 0, 170, 0.66, 0.96, 5000, null, 15, new double[] { -1.2 }, null, 0.98, 1.98),
	locoDieselGP7Red("Loco Diesel GP7",EntityLocoDieselGP7Red.class, 59,ItemIDs.minecartGP7Red.item,"train_gp7","diesel",850,70,0,50,0,200,0.74,0.96,20000,new String[] {"Red","Blue","Black","Yellow"},15,new double[]{-1.4},null,0.98,1.98),
	locoDieselSD40("Loco Diesel SD40",EntityLocoDieselSD40.class, 21,ItemIDs.minecartLocoSD40.item,"train_sd40","diesel",900,80,0,60,0,200,0.8,0.97,20000,new String[] {"Red","Yellow","Black","Green","Orange","Magenta","Blue"},10,new double[]{-2.3},null,0.98,1.98),
	locoDieselSD70("Loco Diesel SD70",EntityLocoDieselSD70.class, 113,ItemIDs.minecartLocoSD70.item,"train_sd70","diesel",900,80,0,60,0,200,0.8,0.97,20000,new String[] {"Orange","Yellow","Red","Blue","Magenta","Black"},10,new double[]{-2.3},null,0.98,1.98),
	locoDieselShunter("Loco Diesel Shunter", EntityLocoDieselShunter.class, 11, ItemIDs.minecartShunter.item,
			"train_shunter", "diesel", 800, 70, 0, 70, 0, 260, 0.6, 0.94, 8000,
			new String[] { "Blue", "Green", "Red", "Black" }, 14, new double[] { -2.58 }, null, 0.98, 1.98),
	locoDieselV60_DB("Loco Diesel V60 DB",EntityLocoDieselV60_DB.class, 49,ItemIDs.minecartV60_DB.item,"train_v60","diesel",500,80,0,60,0,170,0.66,0.96,8000,new String[] {"Red","Green","Yellow","Cyan"},15,new double[]{-1.3},null,0.98,1.98),

	/** Electric */
	locoElectricVL10("Loco Electric VL10", EntityLocoElectricVL10.class, 46, ItemIDs.minecartVL10.item, "train_vl10", "electric", 700, 150, 0, 8, 0, 400, 1.1, 0.956, 0, null, 14, new double[] { -2.3 }, null, 0.98, 1.98),
	locoElectricBR_E69("Loco Electric BR_E69",EntityLocoElectricBR_E69.class, 7,ItemIDs.minecartBR_E69.item,"train_bre69","electric",400,50,0,5,0,400,0.9,0.946,0,new String[] {"Green","Red","Black","Grey"},18,null,null,0.98,1.98),
	locoElectricMineTrain("Loco Electric Minetrain",EntityLocoElectricMinetrain.class,75,ItemIDs.minecartLocoMineTrain.item,"train_mine_train","electric",500,40,0,80,0,160,0.5,0.97,0,null,18,new double[]{-1},null,0.98,0.98),
	locoElectricSpeedZeroED("Loco Electric High Speed ZeroED", EntityLocoElectricHighSpeedZeroED.class, 12,
			ItemIDs.minecartLocoHighSpeedZeroED.item, "train_high_speed_loco_zeroed", "electric", 700, 237, 0, 3, 0,
			230, 1.4, 0.98, 0, null, 13, new double[] { -3.4 }, null, 0.98, 1.98),
	//locoSpeedGrey("Loco High Speed",EntityLocoElectricNewHighSpeedLoco.class, 36,null,null,0.98,0.98),
	locoElectricTramYellow("Loco Electric Yellow Wood Tram",EntityLocoElectricTramWood.class, 24,ItemIDs.minecartTramWood.item,"train_tram","electric",300,55,0,10,0,140,0.5,0.965,0,null,14,new double[]{-2},null,0.98,1.98),
	locoElectricTramNY("Loco Electric Tram NY", EntityLocoElectricTramNY.class, 23, ItemIDs.minecartNYTram.item,
			"train_tram_ny", "electric", 400, 65, 0, 10, 0, 170, 0.7, 0.965, 0, null, 18, new double[] { -3 }, null,
			0.98, 1.98),

	/** Steam */
	locoSteamA4("Loco Steam A4 Mallard", EntityLocoSteamMallardA4.class, 53, ItemIDs.minecartLocoA4Mallard.item,
			"train_loco_a4_mallard", "steam", 1100, 140, 0, 60, 150, 160, 0.8, 0.97, 10000, new String [] {"Blue", "Yellow", "Black", "Green", "White"}, 7,
			new double[] { -2.5 }, null, 0.98, 1.98),
	locoSteamCherepanov("Loco Steam Cherepanov",EntityLocoSteamCherepanov.class, 74,ItemIDs.minecartLocoCherepanov.item,"train_cherpanov","steam",150,30,0,40,120,120,0.3D,0.98D,3000,null,18,new double[]{-1.7},null,0.98,0.98),
	locoSteamBR80("Loco Steam BR80",EntityLocoSteamBR80_DB.class, 102,ItemIDs.minecartLocoBR80_DB.item,"train_br80","steam",350,45,0,100,130,135,0.45,0.97,7000,new String [] {"Black", "Green"},16,new double[]{-1.1},null,0.98,1.98),
	locoSteam4_4_0("Loco Steam 4-4-0",EntityLocoSteam4_4_0.class, 13,ItemIDs.minecartPower.item,"train_steam_normal","steam",400,50,0,40,160,190,0.65,0.95,5000,new String[] {"Red","White","Blue","Brown","Green","Black"},16,new double[]{-2},null,0.98,1.98),
	locoSteamSmall("Loco Steam Small",EntityLocoSteamSmall.class, 19, ItemIDs.minecartLoco3.item,"train_steam_small", "steam",250,45,0,140,140,160,0.5D,0.968D,5000,new String[] {"Blue","Red","Green","Yellow","Black"},18,new double[]{-1.7},null,0.98,0.98),
	//locoHeavySteam("Loco Steam Heavy",EntityLocoHeavySteam.class, 33,,"train_steam_heavy",null,0.98,null,0.98),//removed
	locoSteamC62Class("Loco Steam C62Class", EntityLocoSteamC62Class.class, 14, ItemIDs.minecartLocoC62Class.item,
			"train_loco_c62_class", "steam", 500, 129, 0, 60, 180, 160, 0.7, 0.97, 10000, null, 7,
			new double[] { -5.66 }, null, 0.98, 1.98),
	locoSteamBR01_DB("Loco Steam BR01", EntityLocoSteamBR01_DB.class, 101, ItemIDs.minecartLocoBR01_DB.item,
			"train_br01", "steam", 700, 120, 0, 60, 200, 300, 0.6, 0.97, 10000, null, 10, new double[] { -3.7 }, null,
			0.98, 1.98),
	locoSteamEr_USSR("Loco Steam ER_USSR", EntityLocoSteamEr_Ussr.class, 8, ItemIDs.minecartLocoEr.item, "train_ussr",
			"steam", 800, 80, 0, 80, 100, 200, 0.35, 0.975, 10000, null, 10, new double[] { -3.7 }, null, 0.98, 1.98),
	locoSteamForney("Loco Steam Forney",EntityLocoSteamForneyRed.class, 97,ItemIDs.minecartLocoForneyRed.item,"train_forney","steam",600,70,0,60,160,130,0.44,0.968,8000,new String[] {"Red","Grey","Yellow","Brown","Blue","Green"},15,new double[]{-1.35},null,0.98,1.98),
	locoSteamMogul("Loco Steam Mogul",EntityLocoSteamMogulBlue.class, 93,ItemIDs.minecartLocomogulBlue.item,"train_mogul","steam",500,65,0,50,180,180,0.56,0.967,5000,new String[] {"Blue","Black","Brown","Green","Red","White"},15,new double[]{-2.2},null,0.98,1.98),
	locoSteamShay("Loco Steam Shay",EntityLocoSteamShay.class, 100,ItemIDs.minecartLocoSteamShay.item,"train_shay","steam",250,50,0,50,160,130,0.5,0.968,4000,null,15,new double[]{-1.5},null,0.98,1.98),
	locoSteamAdler("Loco Steam Adler",EntityLocoSteamAdler.class, 98,ItemIDs.minecartLocoSteamAdler.item,"train_adler","steam",200,45,0,60,160,300,0.5,0.968,3000,null,15,new double[]{-1.5},null,0.98,1.98);

	
	private String internalName;
	private Class entityClass;
	private Item item;
	private int entityID;
	private String itemIconName;
	private String trainType;
	private int MHP;
	private int maxSpeed;
	private double mass;
	private int fuelConsumption;
	private int waterConsumption;
	private int heatingTime;
	private double accelerationRate;
	private double brakeRate;
	private int tankCapacity;
	private String[] colors;
	private int guiRenderScale;
	private double[] bogieLocoPositions;
	private double[] bogieUtilityPositions;
	private double width;
	private double height;
	private String[] additionnalTooltip;
	private int cargoCapacity;
	
	/**
	 * 
	 * @param internalName : Only used by EntityRegistry
	 * @param entityClass
	 * @param entityID: Current free IDs: 55,56,57,58,61,63,64,65,78,79,80,81,82,89,90,91,92,94
	 * @param item
	 * @param itemIconName currently unused
	 * @param trainType: "steam", "diesel", "freight", "passenger", "special", "flat", "electric"
	 * @param MHP: power of the locomotive
	 * @param maxSpeed
	 * @param mass (will be multiplied by 10 internally. That means putting 0.1 here will create a mass of 1 Ton in game)
	 * @param fuelConsumption: 1 unit is consumed every x ticks
	 * @param waterConsumption: 1 unit is consumed every x ticks
	 * @param heatingTime
	 * @param accelerationRate: generally around 0.45
	 * @param brakeRate: generally around 0.98
	 * @param tankCapacity
	 * @param colors: an array with all possible colors. Index 0 is used as default color when train is first spawned. leave null if no color available
	 * @param guiRenderScale: scale at which the entity will be rendered inside the GUI (crafting GUI)
	 */
	private EnumTrains(String internalName,Class entityClass, int entityID, Item item, String itemIconName, String trainType,int MHP,int maxSpeed, double mass, int fuelConsumption, int waterConsumption, int heatingTime, double accelerationRate, double brakeRate, int tankCapacity, String[] colors, int guiRenderScale, double[] bogieLocoPositions, double[] bogieUtilityPositions, double width, double height){
		this.internalName = internalName;
		this.entityClass = entityClass;
		this.item = item;
		this.entityID=entityID;
		this.itemIconName=itemIconName;
		this.trainType=trainType;
		this.MHP=MHP;
		this.maxSpeed=maxSpeed;
		this.mass=mass;
		this.fuelConsumption=fuelConsumption;
		this.waterConsumption=waterConsumption;
		this.heatingTime=heatingTime;
		this.accelerationRate=accelerationRate;
		this.brakeRate=brakeRate;
		this.tankCapacity=tankCapacity;
		this.colors=colors;
		this.guiRenderScale = guiRenderScale;
		this.bogieLocoPositions = bogieLocoPositions;
		this.bogieUtilityPositions = bogieUtilityPositions;
		this.width=width;
		this.height=height;
	}
	
	/**
	 * Constructor for additionnal tooltips on the item
	 * @param internalName
	 * @param entityClass
	 * @param entityID
	 * @param item
	 * @param itemIconName
	 * @param trainType
	 * @param MHP
	 * @param maxSpeed
	 * @param mass
	 * @param fuelConsumption
	 * @param waterConsumption
	 * @param heatingTime
	 * @param accelerationRate
	 * @param brakeRate
	 * @param tankCapacity
	 * @param colors
	 * @param guiRenderScale
	 * @param bogieLocoPositions
	 * @param bogieUtilityPositions
	 * @param width
	 * @param height
	 * @param additionnalTooltip
	 */
	private EnumTrains(String internalName,Class entityClass, int entityID, Item item, String itemIconName, String trainType,int MHP,int maxSpeed, double mass, int fuelConsumption,int waterConsumption, int heatingTime, double accelerationRate, double brakeRate, int tankCapacity, String[] colors, int guiRenderScale, double[] bogieLocoPositions, double[] bogieUtilityPositions, double width, double height, String[] additionnalTooltip){
		this.internalName = internalName;
		this.entityClass = entityClass;
		this.item = item;
		this.entityID=entityID;
		this.itemIconName=itemIconName;
		this.trainType=trainType;
		this.MHP=MHP;
		this.maxSpeed=maxSpeed;
		this.mass=mass;
		this.fuelConsumption=fuelConsumption;
		this.waterConsumption=waterConsumption;
		this.heatingTime=heatingTime;
		this.accelerationRate=accelerationRate;
		this.brakeRate=brakeRate;
		this.tankCapacity=tankCapacity;
		this.colors=colors;
		this.guiRenderScale = guiRenderScale;
		this.bogieLocoPositions = bogieLocoPositions;
		this.bogieUtilityPositions = bogieUtilityPositions;
		this.width=width;
		this.height=height;
		this.additionnalTooltip=additionnalTooltip;
	}
	
	/**
	 * Constructor for freight carts
	 * @param internalName
	 * @param entityClass
	 * @param entityID
	 * @param item
	 * @param itemIconName
	 * @param trainType
	 * @param mass
	 * @param colors
	 * @param guiRenderScale
	 * //@param bogieLocoPositions
	 * //@param bogieUtilityPositions
	 * @param width
	 * @param height
	 * @param cargoCapacity
	 * @param additionnalTooltip
	 */
	private EnumTrains(String internalName,Class entityClass, int entityID, Item item, String itemIconName, String trainType, double mass, String[] colors, int guiRenderScale, double width, double height, int cargoCapacity, String[] additionnalTooltip){
		this.internalName = internalName;
		this.entityClass = entityClass;
		this.item = item;
		this.entityID=entityID;
		this.itemIconName=itemIconName;
		this.trainType=trainType;
		this.mass=mass;
		this.colors=colors;
		this.guiRenderScale = guiRenderScale;
		this.width=width;
		this.height=height;
		this.additionnalTooltip=additionnalTooltip;
		this.cargoCapacity = cargoCapacity;
	}
	
	public String getInternalName(){
		return this.internalName;
	}
	
	public Item getItem(){
		return this.item;
	}
	
	public int getEntityID(){
		return this.entityID;
	}
	
	public String getItemIcon(){
		return this.itemIconName;
	}
	
	public String getTrainType(){
		return this.trainType;
	}
	
	public int getMHP(){
		return this.MHP;
	}
	
	public int getMaxSpeed(){
		return this.maxSpeed;
	}
	
	public double getMass(){
		return this.mass;
	}
	
	public double getWidth(){
		return this.width;
	}
	
	public double getHeight(){
		return this.height;
	}
	
	public int getFuelConsumption(){
		return this.fuelConsumption;
	}
	
	public int getWaterConsumption(){
		return this.waterConsumption;
	}
	
	public int getHeatingTime(){
		return this.heatingTime;
	}
	
	public double getAccelerationRate(){
		return this.accelerationRate;
	}
	
	public double getBrakeRate(){
		return this.brakeRate;
	}
	
	public int getTankCapacity(){
		return this.tankCapacity;
	}
	
	public String[] getColors(){
		return this.colors;
	}
	
	public double[] getBogieLocoPositions(){
		return this.bogieLocoPositions;
	}
	
	public double[] getBogieUtilityPositions(){
		return this.bogieUtilityPositions;
	}
	
	public Class getEntityClass() {
		return this.entityClass;
	}
	
	public int getGuiRenderScale(){
		return this.guiRenderScale;
	}
	
	public String[] getAdditionnalTooltip(){
		return this.additionnalTooltip;
	}
	
	public int getCargoCapacity(){
		return cargoCapacity;
	}
	
	public static EnumTrains getCurrentTrain(Item item){
		if(item==null)return null;
		for (EnumTrains trains : EnumTrains.values()) {
			if(trains!=null && trains.getItem()!=null && trains.getItem() == item){
				return trains;
			}
		}
		return null;	
	}
	
	public static AbstractTrains getEntityWithItem(Item item, World world, double x, double y, double z){
		if(item==null)return null;
		for (EnumTrains trains : EnumTrains.values()) {
			if(trains!=null && trains.getItem()!=null && trains.getItem() == item){
				return trains.getEntity(world, x, y, z);
			}
		}
		return null;
	}
	
	public AbstractTrains getEntity(World world){
		try {
			return (AbstractTrains) entityClass.getConstructor(World.class).newInstance(world);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public AbstractTrains getEntity(World world, double x, double y, double z){
		try {
			return (AbstractTrains) entityClass.getConstructor(World.class,double.class,double.class,double.class).newInstance(world,x,y,z);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
}