//
//  ComposeView.swift
//  iosContactsMP
//
//  Created by Ridha Ahmad Firdaus on 09/01/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI

struct ComposeView: UIViewControllerRepresentable {
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
        
    }
    
    func makeUIViewController(context: Context) -> some UIViewController {
        MainViewControllerKt.MainViewController()
    }
}
