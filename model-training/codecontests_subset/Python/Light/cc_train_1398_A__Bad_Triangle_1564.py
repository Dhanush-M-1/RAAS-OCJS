import random


def gcd(a, b):
    if a == 0:
        return b
    return gcd(b % a, a)


def lcm(a, b):
    return (a * b) / gcd(a, b)


for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    #= map(int, input().split())
    f=a[0]
    s=-1
    t=a[n-1]
    for i in range(1,n-1):
        if a[i]+f<=t:
            s=i
            break
    if (s==-1):
        print(-1)
    else:
        print(1,s+1,n)