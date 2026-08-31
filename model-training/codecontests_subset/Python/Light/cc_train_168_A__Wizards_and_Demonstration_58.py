from math import ceil
n,x,y = list(map(int, input().split(" ")))
print(ceil(n*y/100)-x if ceil(n*y/100)-x>0 else 0)