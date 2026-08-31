import math

t=int(input()) 
for i in range(t):
    a,b,c,d=map(int,input().split())
    if a<b:
        print("No")
    elif d<b:
        print("No")
    elif c>=b:
        print("Yes")
    elif b-math.gcd(b,d)+(a%math.gcd(b,d))>c:
        print("No")
    else:
        print("Yes")