import math
a,b= map(int,input().split())
ans = a
x = a
while (x>=1):
    x=x/b
    ans+=x
print(math.floor(ans))
    