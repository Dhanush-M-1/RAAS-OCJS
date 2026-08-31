import math

n,x,y = [int(ch) for ch in input().split(' ')]
ans = (math.ceil(y*n/100) - x)
print('0') if ans < 0 else print(ans)