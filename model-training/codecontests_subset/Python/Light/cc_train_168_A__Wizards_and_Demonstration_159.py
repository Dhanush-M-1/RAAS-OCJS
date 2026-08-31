import math as m

n,x,y = list(map(int, input().split()))


a = m.ceil((y/100)*n) 

print(a - x if x <= a else 0)