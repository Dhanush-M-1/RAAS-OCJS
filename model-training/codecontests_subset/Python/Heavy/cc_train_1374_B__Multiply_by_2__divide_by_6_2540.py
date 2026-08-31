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
        ans=0
        while(n!=1):
            f=0
            #print(n)
            if n%6==0:
                n//=6
                ans+=1
                f=1
                continue
                
            if (2*n)%6==0:
                n=n*2
                ans+=1
                f=1
                
            if ans==0 or f==0:
                ans=-1
                break
        
        print(ans)
        
        