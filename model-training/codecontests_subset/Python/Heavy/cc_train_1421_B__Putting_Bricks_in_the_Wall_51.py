# -*- coding: utf-8 -*-
"""
Created on Sat Oct 24 11:08:45 2020

@author: alber
"""

def pink(matrix,n):
    
    counter = 0
    final1 = matrix[n-1][n-2]
    final2 = matrix[n-2][n-1]
    
    entrada1 = matrix[0][1]
    entrada2 = matrix[1][0]
    
    
    if final1 == final2:
        
        if entrada1 == final1:
            
            counter += 1
            x , y = 1, 2
            if entrada2 == final1:
                z, v = 2, 1
                counter += 1
                print(counter)
                print(x, y, end = ' ')
                print()
                print(z, v, end = ' ')
                print()
            else:
                
                print(counter)
                print(x, y, end = ' ')
                print()
        
        elif entrada2 == final1:
            
            counter += 1
            z, v = 2, 1
            print(counter)
            print(z, v, end = ' ')
            print()
            
                
        else:
            print(counter)
     
    else:
        
        if entrada1 == entrada2:
            
            if entrada1 == final1:
                
                counter += 1
                z, v = n, n-1
                print(counter)
                print(z, v, end = ' ')
                print()
                
            
            elif entrada1 == final2:
                
                counter += 1
                z, v = n-1, n
                print(counter)
                print(z, v, end = ' ')
                print()
        
        else:
            counter = 2
            print(counter)
            x, y = 1, 2
            print(x, y, end = ' ')
            print()
            if entrada1 == final1:
                z, v = n-1, n
                print(z, v, end = ' ')
                print()
            else:
                z, v = n, n-1
                print(z, v, end = ' ')
                print()
                
        
                
                
        






test = int(input())



for i in range(test):
    matrix = []
    n = int(input())
    for j in range(n):
        fila = input()
        matrix.append(fila)
            
    
    pink(matrix,n)