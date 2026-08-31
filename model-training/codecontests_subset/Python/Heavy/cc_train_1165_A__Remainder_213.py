from sys import stdin,stdout
from itertools import combinations
from collections import defaultdict,OrderedDict
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
    n,x,y=listIn()
    s=stringIn()
    ans=0
    st="0"*(x-y-1)+'1'+"0"*y
    req_s=s[::-1][:x][::-1]
    #print(req_s,st)
    for i in range(len(st)):
        if req_s[i] is not st[i]:
            ans+=1
    print(ans)
    