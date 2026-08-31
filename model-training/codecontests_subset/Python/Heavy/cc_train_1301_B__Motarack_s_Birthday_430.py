from itertools import permutations
import math
import sys
import queue


if __name__=="__main__":
    T=int(input())
    for TT in range(0,T):
        n=int(input())
        arr=input().split(' ')
        a=[]
        for i in range(0,n):
            arr[i]=int(arr[i])
        ans=0
        for i in range(0,n):
            if arr[i]!=-1:
                if (i and arr[i-1]==-1) or (i<n-1 and arr[i+1]==-1):
                    a.append(arr[i])
                if i<n-1 and arr[i+1]!=-1:
                    ans=max(ans,abs(arr[i]-arr[i+1]))
        L=len(a)
        #print(a)
        if L==0:
            print(str(ans)+' 0')
        elif L==1:
            print(str(ans)+' '+str(a[0]))
        else:
            a.sort()
            ans=max(ans,(a[L-1]-a[0])//2+(a[L-1]-a[0])%2)
            print(ans,end=' ')
            print((a[L-1]+a[0])//2)

        
