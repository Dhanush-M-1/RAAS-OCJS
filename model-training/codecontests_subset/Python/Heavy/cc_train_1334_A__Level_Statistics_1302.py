from collections import *
from itertools import *
from bisect import *

def inp():
    return int(input())
def arrinp():
    return [int(x) for x in input().split()]

def main():
    t = inp()
    for _ in range(t):
        n = inp()
        A = []
        for i in range(n):
            A.append(arrinp())
        possible = True
        p,c = A[0]
        if(p<c):
            print("NO")
            continue
        for i in range(1,n):
            p, c = A[i]
            p_prev, c_prev = A[i-1]
            if(p<c):
                possible = False
                break
            if(c < c_prev):
                possible = False
                break
            if(p<p_prev):
                possible = False
                break
            if(p==p_prev and c!=c_prev):
                possible = False
                break
            if(p>p_prev and c-c_prev >p-p_prev):
                possible=False
                break
        if not possible:
            print("NO")
        else:
            print("YES")

if __name__ == '__main__':
    main()