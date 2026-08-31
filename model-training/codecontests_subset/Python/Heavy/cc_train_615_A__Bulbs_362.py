#!/bin/python3

import sys
from sys import stdin, stdout 

def main():
    arr1=[int(x) for x in stdin.readline().split()]
    arr2=[]
    for i in range(arr1[0]):
        arr2.append("")
    for i in range(arr1[0]):
        tList=[int(x) for x in stdin.readline().split()]
        arr2[i]=tList
    
    bombillos=[x for x in range(1,arr1[1]+1)]
    
    for i in range(0,arr1[0]):
        contador=0
        for j in arr2[i]:
            if not contador==0:
                            bombillos=[x for x in bombillos if (x!=j)]
            contador+=1
         
    if len(bombillos)==0:
        print("YES")
    else:
        print("NO")
   
    
if __name__ == "__main__":
    main()    
        