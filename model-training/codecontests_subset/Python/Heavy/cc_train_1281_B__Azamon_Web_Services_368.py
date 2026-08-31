# -*- coding: utf-8 -*-
"""
Éditeur de Spyder

Ceci est un script temporaire.
"""
def lookForSwipe(string , value , index) :
    res = -1 
    for i , v in enumerate(string[index:]):
        if value >= v :
            value = v 
            res = i + index
        
    return res 
    
def swipe (str1 , ind1 , ind2) :
    str1 = list(str1) 
    str1[ind1] , str1[ind2] = str1[ind2] , str1[ind1]
    return "".join(str1) 
def compare (str1 , str2) :
    if str1 < str2 :
        return str1 , str2
    for i in range(min(len(str1) , len(str2))) :
        if str1[i] < str2[i] :
            return str1 , str2
        else :
            res = lookForSwipe(str1 , str2[i], i+1)
            if res != -1 and str1[res] !=str1[i] : 
                str1 = swipe(str1 , i , res)
                if str1 >= str2 :
                    return -1 ,-1 
                else:
                    return str1 , str2 
            if str1[i] > str2[i] : 
                return -1 , -1
    return -1 ,-1
                

t = int(input())
for i in range (t):
    site , opp = input().split()
    str1 , str2 = compare(site , opp) 
    if str1 == -1 :
        print("---")
    else :
        print(str1)
    
    
    
    
   
    

    
    
    
    