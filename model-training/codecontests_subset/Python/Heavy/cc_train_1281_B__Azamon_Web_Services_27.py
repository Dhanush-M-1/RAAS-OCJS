# -*- coding: utf-8 -*-
"""
Created on Tue Dec 17 18:45:41 2019

@author: USER
"""

def mai(m,b):
        a=list(m)
        l=a
        l.sort()
        str1=""
        str1=str1.join(l)
        if (m<b):
            return m
        elif str1 < b :
            for i in range(len(m)):
                str1=""
                a=list(m)
                if a[i]!=l[i]:
                    for j in range(len(a)-1,-1,-1):
                        if l[i]==a[j]:
                            temp=a[j]
                            a[j]=a[i]
                            a[i]=temp
                            str1=""
                            str1=str1.join(a)
                            if(str1<b):
                                return str1;
                            else:
                                break
                
        return "---"
            
        
            
for i in range (int(input())):
        print(mai(*input().split()))