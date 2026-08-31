import sys
import math
def get_array(): return list(map(int, sys.stdin.readline().strip().split()))
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def input(): return sys.stdin.readline().strip()
for _ in range(int(input())):
    n=int(input())
    z=[]
    for i in range(n):
        z.append(input())
    ans=[]
    if z[0][1]=="0" and z[1][0]=="0":
        if z[n-2][n-1]=="0":
            ans.append(list([n-2+1,n-1+1]))
        if z[n-1][n-2]=="0":
            ans.append(list([n-1+1,n-2+1]))
    elif z[0][1]=="1" and z[1][0]=="1":
        if z[n-2][n-1]=="1":
            ans.append(list([n-2+1,n-1+1]))
        if z[n-1][n-2]=="1":
            ans.append(list([n-1+1,n-2+1]))
    elif z[0][1] == "1" and z[1][0] == "0":
        if z[n - 2][n - 1] == "0" and z[n-1][n-2]=="0":
            ans.append(list([2,1]))
        elif z[n - 1][n - 2] == "1" and z[n-2][n-1]=="1":
            ans.append(list([1,2]))
        elif z[n-1][n-2]=="1" and z[n-2][n-1]=="0":
            ans.append(list([1,2]))
            ans.append(list([n-2+1,n-1+1]))
        elif z[n-1][n-2]=="0" and z[n-2][n-1]=="1":
            ans.append(list([2,1]))
            ans.append(list([n-2+1,n-1+1]))
    elif z[0][1] == "0" and z[1][0] == "1":
        if z[n - 2][n - 1] == "0" and z[n-1][n-2]=="0":
            ans.append(list([1,2]))
        elif z[n - 1][n - 2] == "1" and z[n-2][n-1]=="1":
            ans.append(list([2,1]))
        elif z[n-1][n-2]=="1" and z[n-2][n-1]=="0":
            ans.append(list([2,1]))
            ans.append(list([n-2+1,n-1+1]))
        elif z[n-1][n-2]=="0" and z[n-2][n-1]=="1":
            ans.append(list([1,2]))
            ans.append(list([n-2+1,n-1+1]))
    if len(ans)==0:
        print(0)
    else:
        print(len(ans))
        for i in range(len(ans)):
            print(*ans[i])