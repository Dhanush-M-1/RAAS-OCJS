from collections import defaultdict
import copy 
def ii():return int(input())
def si():return input()
def li():return list(map(int,input().split()))
def mi():return map(int,input().split())
t=ii()
for _ in range(t):
    n=ii()
    arr=li()
    flag=False
    a=arr[0]
    b=arr[1]
    for i in range(n-1,1,-1):
        if (a+b<=arr[i]):
            print(1,2,i+1)
            flag=True
            break
    if(flag==False):
        print(-1)   