#!/usr/bin/python3 -SOO
a,b = map(int,input().strip().split())
c = 0
t = 0
while a:
    a -= 1
    c += 1
    t += 1
    if c >= b:
        c -= b
        a += 1
print(t)
        
