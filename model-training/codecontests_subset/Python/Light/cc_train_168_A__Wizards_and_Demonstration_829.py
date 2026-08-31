# cook your dish here
import math
n,x,y = map(int, input().split())
re = (y*n)/100
r = math.ceil(re)
if x>=r:
    print("0")
else:
    print(r - x)