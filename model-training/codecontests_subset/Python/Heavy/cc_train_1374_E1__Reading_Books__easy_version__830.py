import sys
import random
from math import *
 
def input():
    return sys.stdin.readline().strip()
 
def iinput():
    return int(input())

def finput():
    return float(input())

def tinput():
    return input().split()

def linput():
    return list(input())
 
def rinput():
    return map(int, tinput())

def fiinput():
    return map(float, tinput())
 
def rlinput():
    return list(map(int, input().split()))
def trinput():
    return tuple(rinput())

def srlinput():
    return sorted(list(map(int, input().split())))

def NOYES(fl):
    if fl:
        print("NO")
    else:
        print("YES")
def YESNO(fl):
    if fl:
        print("YES")
    else:
        print("NO")
    
def main():  
    #n = iinput()
    #k = iinput() 
    #m = iinput() 
    #n = int(sys.stdin.readline().strip()) 
    n, k = rinput()
    #n, m = rinput()
    #m, k = rinput()
    #n, k, m = rinput()
    #n, m, k = rinput()
    #k, n, m = rinput()
    #k, m, n = rinput() 
    #m, k, n = rinput()
    #m, n, k = rinput()
    #q = srlinput()
    #q = linput()
    q = []
    for i in range(n):
        q.append(rlinput())
    q.sort()
    w,e,r, fak,pr,pe,pw = [], [], [], [], [0],[0],[0]
    res1, res2 = 0, 0
    for i in range(n):
        res1, res2 = res1 + q[i][1], res2 + q[i][2]
        if q[i][1] and q[i][2]:
            w.append(q[i][0])
            pw.append(w[-1] + pw[-1])
        elif q[i][1]:
            e.append(q[i][0])
            pe.append(e[-1] + pe[-1])         
        elif q[i][2]:
            r.append(q[i][0])
            pr.append(r[-1] + pr[-1])        
        else:
            fak.append(q[i])   
    if min(res1, res2) < k:
        print(-1)
    else:
        res = 5e9
        for i in range(1 + min(k, len(w))):
            if k - i <= min(len(r), len(e)):
                res = min(res, pw[i] + pr[k - i] + pe[k - i])
        print(res)
    
                
        
    
            
    
    

    
for inytd in range(1):
    main()