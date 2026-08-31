import math
a,b,c = map(int,input().split())
w = (a * c) / 100
if w-b < 0:
    print(0)
else:
    print(math.ceil(w-b))