import sys
import math
import bisect
 
 
sys.setrecursionlimit(1000000000)
def input():
    return sys.stdin.readline().strip()
 
def iinput():
    return int(input())
 
def finput():
    return float(input())
 
def tinput():
    return input().split()
 
def rinput():
    return map(int, tinput())
 
def rlinput():
    return list(rinput())

def main():
    n = iinput()
    c = rlinput()
    q = n//2
    w = [[c[0], 0]]
    for i in c:
        if (w[-1][0] == i):
            w[-1][1] += 1
        else:
            w.append([i,1])
    res1, res2, res3 = 0, 0, 0
    if (len(w) <= 3):
        print(0, 0, 0)
    else:
        res1 = w[0][1]
        res2 = w[1][1]
        i = 2
        n= len(w)
        while ((res1 >= res2) and (i != n)):
            res2 += w[i][1]
            i += 1
        s = res1 + res2
     
        while ((i != n) and (w[i][1] + s <= q)):
            s += w[i][1]
            res3 += w[i][1]
            i += 1
        if ((s > q) or (res1 * res2 * res3 == 0) or (res1 >= res2) or (res3 <= res1)):
            print(0,0,0)
        else:
            print(res1, res2, res3)
        
for j in range(int(input())):
    main()