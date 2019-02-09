//
//  AppDelegate.swift
//  Arquivo
//
//  Created by Valéria Cavalcanti on 09/02/2019.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?
    var cadastro: Cadastro
    var arquivo: String!

    override init() {
        self.cadastro = Cadastro()
    }

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        // Override point for customization after application launch.
        
        self.arquivo = "\(NSHomeDirectory())/Documents/dados.dat"
        
        do{
            let nd = NSData(contentsOfFile: self.arquivo!)
            if (nd != nil){
                let d = Data(referencing: nd!)
                self.cadastro = try NSKeyedUnarchiver.unarchiveTopLevelObjectWithData(d) as! Cadastro
            }else{
                self.cadastro = Cadastro()
            }
        }catch{
            self.cadastro = Cadastro()
        }
        
        return true
    }

    func applicationWillResignActive(_ application: UIApplication) {
        // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
        // Use this method to pause ongoing tasks, disable timers, and invalidate graphics rendering callbacks. Games should use this method to pause the game.
    }

    func applicationDidEnterBackground(_ application: UIApplication) {
        // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later.
        // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
        
        do{
            let d = try NSKeyedArchiver.archivedData(withRootObject: self.cadastro, requiringSecureCoding: false)
            let url = URL(fileURLWithPath: self.arquivo)
            try d.write(to: url)
        }catch let errors{
            print(errors)
        }
    }

    func applicationWillEnterForeground(_ application: UIApplication) {
        // Called as part of the transition from the background to the active state; here you can undo many of the changes made on entering the background.
    }

    func applicationDidBecomeActive(_ application: UIApplication) {
        // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
    }

    func applicationWillTerminate(_ application: UIApplication) {
        // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
    }


}

