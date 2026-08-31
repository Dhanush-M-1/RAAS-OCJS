import sys

a, b = [int(el) for el in input().split()] 
res = a
cond = True
while cond:
    div, mod = divmod(a, b)
    a = div + mod
    res += div
    cond = a >= b
    
print(res)
