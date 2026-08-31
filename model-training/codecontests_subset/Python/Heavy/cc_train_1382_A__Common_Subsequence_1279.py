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
        n,m=listIn()
        a=listIn()
        b=listIn()
        di=Counter(b)
        f=0
        for ele in a:
            if di[ele]>=1:
                ans=ele
                f=1
                break
        if f:
            print("YES")
            print(1,ele)
        else:
            print("NO")