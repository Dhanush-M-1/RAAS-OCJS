from sys import stdin,stdout
from itertools import combinations
from collections import defaultdict
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
        s=stringIn()
        if s[0]=="<" and s[-1]==">":
            m1,m2=0,0
            for i in range(n):
                if s[i]=="<":
                    m1+=1
                else:
                    break
            for i in range(n-1,-1,-1):
                if s[i]==">":
                    m2+=1
                else:
                    break
            print(min(m1,m2))
        else:
            print(0)
        
        
    
