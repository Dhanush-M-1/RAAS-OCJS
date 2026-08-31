from math import ceil
[n,x,y] = list(map(int, input().split()))
print(ceil((n*y/100)-x) if x/n*100<y else 0)