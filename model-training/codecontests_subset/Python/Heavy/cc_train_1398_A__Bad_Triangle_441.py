from sys import stdin,stdout
from itertools import combinations
from collections import defaultdict,Counter
import math
 
def listIn():
    return list((map(int,stdin.readline().strip().split())))
 
def stringListIn():
    return([x for x in stdin.readline().split()])
    
def intIn():
    return (int(stdin.readline()))
 
def stringIn():
    return (stdin.readline().strip())
    
 
if __name__=="__main__":
    t=intIn()
    while(t>0):
        t-=1
        n=intIn()
        a=listIn()
        f=0
        s=a[0]+a[1]
        for i in range(2,n):
            if s<=a[i]:
                f=1
                break
        
        if f:
            print(1,2,i+1)
        else:
            print(-1)
            
            
    