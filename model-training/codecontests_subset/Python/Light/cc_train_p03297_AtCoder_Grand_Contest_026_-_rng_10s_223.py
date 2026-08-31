# coding: utf-8
# Your code here!
import fractions

def isok(a,b,c,d):
    if a < b or b > d:
        print('No')
        return
    g= fractions.gcd(d, b)
    r=((c-a%g)//g)*g+a%g
#    print(r)
    if r+g-b < 0:
        print('No')
    else:
        print('Yes')
    

T=int(input())

for _ in range(T):
    a,b,c,d = list(map(int,input().split()))
    isok(a,b,c,d)

