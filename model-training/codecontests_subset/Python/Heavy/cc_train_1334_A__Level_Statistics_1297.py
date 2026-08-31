import sys
import heapq

def input():
    return sys.stdin.readline().strip()
 
def iinput():
    return int(input())
 
def rinput():
    return map(int, input().split())

def rlinput():
    return list(map(int, input().split()))

def YES(flag):
    if flag:
        return "YES"
    return "NO" 

def main():
    #n = int(sys.stdin.readline().strip())
    
    n = iinput()
    res, a, z = True, 0, 0
    for i in range(n):
        p, c = rinput()
        if p < a or c < z or p + z < c + a:
            res = False
        a, z = p, c  
    print(YES(res))
for i in range(iinput()):
    main()