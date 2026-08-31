import math
n,x,y = map(int, input().split())
print(max(math.ceil(n*y/100)-x,0))