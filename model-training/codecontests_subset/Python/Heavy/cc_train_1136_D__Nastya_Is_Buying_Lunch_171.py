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
    n,m=listIn()
    p=listIn()
    pairs=set()
    for i in range(m):
        u,v=listIn()
        pairs.add((u,v))
    
    stack=[p[-1]]
    p=p[:-1]
    c=n-1
    total=0
    while(c>0):
        pupil=p.pop(-1)
        f=1
        for ele in stack:
            if (pupil,ele) in pairs:
                continue
            else:
                f=0
                break
        if f:
            total+=1
        else:
            stack.append(pupil)
        c-=1
        #print(stack,total)
    print(total)
            
        

    
        
