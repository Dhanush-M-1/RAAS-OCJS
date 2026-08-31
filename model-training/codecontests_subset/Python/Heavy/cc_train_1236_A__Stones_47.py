# -*- coding: utf-8 -*-
"""
Created on Thu Oct 17 19:30:05 2019

@author: Somik Dhar
"""

t = int(input()) #no of test cases

ti = []  #the inputs to the correspoonding test cases
for i in range(0,t):
    a= input()
    z = [int(j) for j in a.split()]
    ti.append(z)
    
a = len(ti)
  
def total_stones(a,b,c):
    total = 0
    while((a > 0 and b > 1 ) or (b > 0 and c > 1)):
        
        z = max(b,c)
        if z == b :
            if a == 0 and c != 0:
                b = b - 1
                c = c - 2
                total = total + 3
                
            else:
                a = a - 1
                b = b - 2
            
                total = total + 3
            
        elif z == c and c!= 0 and b != 0:
            b = b - 1
            c = c - 2
            total = total + 3
          
        elif b == c :
            b = b-1
            c = c -2
            total = total + 3
    return total        
             
for i in range(0,a):
    l = [int(i) for i in ti[i]]
    
    
    a = l[0]
    b = l[1]
    c = l[2]
    #minimum value of a = 1
    #minimum vakue of b = 1
    """
    When Alice picks 1 from a then she can pick 2 from b
    When Alice picks 1 from b then she can pick 2 from c
    """
    print(total_stones(a,b,c))