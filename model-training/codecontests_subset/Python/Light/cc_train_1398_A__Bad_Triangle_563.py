import math
m=1000000007

def fact(n):
    ans=1
    for i in range(1,n+1):
        ans=((ans%m)*(i%m))%m
    return ans

def power_2(n):
    ans=1
    for i in range(n):
        ans=((ans%m)*(2))%m
    return ans


for z in range(int(input())):
    n=int(input())
    flag=True
    a=[int(i) for i in input().split()]
    for i in range(n-2):
        if(a[i]+a[i+1]<=a[n-1]):
            flag=False
            print(i+1,i+2,n)
            break
    if(flag):
        print("-1")
