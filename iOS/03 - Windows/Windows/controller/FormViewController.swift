//
//  FormViewController.swift
//  Windows
//
//  Created by IFPB on 20/12/18.
//  Copyright © 2018 IFPB. All rights reserved.
//

import UIKit

class FormViewController: UIViewController {

    @IBAction func salvar(_ sender: Any) {
        print("Salvou")
        self.navigationController?.popViewController(animated: true)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        print("FormViewController")
    }
    
}
