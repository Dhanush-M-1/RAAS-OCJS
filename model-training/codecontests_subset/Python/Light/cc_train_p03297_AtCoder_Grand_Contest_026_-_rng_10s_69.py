import math
t=int(input())
for i in range(t):
 a,b,c,d=map(int,input().split())
 if b>a:print("No")
 elif b>d:print("No")
 elif c>=b:print("Yes")
 else:g=math.gcd(b,d);print("Yes"if c>=a%g+b-g else"No")