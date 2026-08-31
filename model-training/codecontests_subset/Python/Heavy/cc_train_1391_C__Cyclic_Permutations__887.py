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
    
    n=intIn()
    
    MOD=10**9+7
    fact=[1]*(n+1)
    
    for i in range(2,n+1):
        fact[i]=(fact[i-1]*i)%MOD
    
    
    ans=(fact[n]-2**(n-1))%MOD
        
    
    print(ans)
        
        
        
        