import math
a,b,c=map(int,input().split())
print(math.ceil(-min(0,-a*c/100+b)))