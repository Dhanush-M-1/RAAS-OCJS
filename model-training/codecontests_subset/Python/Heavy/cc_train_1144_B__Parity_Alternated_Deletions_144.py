from sys import stdin,stdout
from itertools import combinations
from collections import defaultdict
import math
import heapq

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
    a=listIn()
    e,o=[],[]
    for i in range(n):
        if a[i]%2==0:
            e.append(a[i])
        else:
            o.append(a[i])
    #print(e,o)
    if len(e)==n:
        e.sort()
        print(sum(e[:-1]))
        exit(0)
    if len(o)==n:
        o.sort()
        print(sum(o[:-1]))
        exit(0)
    e1,o1=len(e),len(o)
    e.sort()
    o.sort()
    if e1==o1:
        print(0)
    else:
        if e1>o1:
            d=e1-o1
            print(sum(e[:d-1]))
        else:
            d=o1-e1
            print(sum(o[:d-1]))
                
    
        
    
    
    
    
    
    
    
    
