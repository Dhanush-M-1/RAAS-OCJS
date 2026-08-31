import sys
import math
input=sys.stdin.readline

t=int(input())
for _ in range(t):
    n=int(input())
    arr=list(map(int,input().split()))
    maxi=-1
    ind=-1
    for i in range(n):
        if(arr[i]<i ):
            maxi=arr[i]
            ind=i-1
            break
    flag=0
    if(ind!=-1):
        for i in range(ind):
            if(arr[i]<i):
                flag=1
                break
        for i in range(ind+1,n):
            if(arr[i]<n-i-1 ):
                flag=1
                break
            else:
                arr[i]=n-i-1
                if(arr[i]==arr[ind]):
                    flag=1
                    break
            
    if(flag):
        print("No")
    else:
        print("Yes")
    
    
                
        