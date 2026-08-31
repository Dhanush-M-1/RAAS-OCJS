import math
n,w,p = map(int,input().split())

needed = int(math.ceil((n*p)/100))
ans = needed-w
if ans > 0:
    print(ans)
else:
    print(0)