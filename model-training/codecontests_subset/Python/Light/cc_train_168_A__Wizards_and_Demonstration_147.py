import math
n,x,y=map(int, input().split())
v=(math.ceil((y*n)/100))
print(v-x) if v-x>0 else print('0')