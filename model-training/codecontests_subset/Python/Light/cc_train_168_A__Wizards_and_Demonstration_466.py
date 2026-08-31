import math as m
n=[float(i) for i in input().split()]
o=m.ceil(n[0]*(n[2]/100))
print(o-int(n[1]) if o>=int(n[1]) else 0)