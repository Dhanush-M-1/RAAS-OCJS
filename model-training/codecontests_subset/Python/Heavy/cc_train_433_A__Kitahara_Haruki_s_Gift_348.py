import sys,os,io,time,copy
if os.path.exists('input.txt'):
    sys.stdin = open('input.txt', 'r')
    sys.stdout = open('output.txt', 'w')

import math

def divide(arr,N):
        req=sum(arr)
        if req%2!=0:
            return 0
        else:
            req=req//2
            table=[False]*(req+1)
            for i in range(N):
                for j in range(req):
                    if table[j]==True and j+arr[i]<=req:
                        table[j+arr[i]]=True
                if arr[i]<=req:
                    table[arr[i]]=True
            if table[req]==True:
                return True
            else:
                return False

def main():
    n=int(input())
    arr=list(map(int,input().split()))
    if divide(arr,n):
        print("YES")
    else:
        print("NO")
    
main()

