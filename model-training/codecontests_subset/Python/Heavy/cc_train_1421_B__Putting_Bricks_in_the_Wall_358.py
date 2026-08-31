#Consistency is the key.
#code by: amritanshu
from sys import stdin,stdout
import math
from collections import deque
input=stdin.readline
def print(*args,end='\n'):
    s=[]
    for i in args:
        s.append(str(i)+' ')
    s=''.join(s)
    stdout.write(s+end)


def solve():
    n=int(input())
    mat=[]
    for i in range(n):
        mat.append(list(input()))
    ans=[]

    if mat[0][1]==mat[1][0] and mat[n-1][n-2]==mat[n-2][n-1] and mat[n-1][n-2]!=mat[0][1]:
        print(0)
        return
    elif mat[0][1]==mat[1][0] and mat[n-1][n-2]==mat[n-2][n-1] and mat[n-1][n-2]==mat[0][1]:
        print(2)
        print(1,2)
        print(2,1)
        return

    if mat[0][1]==mat[1][0] or mat[n-1][n-2]==mat[n-2][n-1]:
        if mat[0][1]==mat[1][0]:
            if mat[n-2][n-1]==mat[0][1]:
                print(1)
                print(n-1,n)
            else:
                print(1)
                print(n,n-1)
        else:
            if mat[0][1]==mat[n-1][n-2]:
                print(1)
                print(1,2)
            else:
                print(1)
                print(2,1)
    else:
        if mat[0][1]==mat[n-1][n-2]:
            print(2)
            print(1,2)
            print(n-1,n)
        elif mat[1][0]==mat[n-2][n-1]:
            print(2)
            print(2,1)
            print(n,n-1)
        elif mat[1][0]==mat[n-1][n-2]:
            print(2)
            print(2,1)
            print(n-1,n)
        else:
            print(2)
            print(1,2)
            print(n,n-1)
            

                                    
tt=1
tt=int(input())
for __ in range(tt):
    solve()
