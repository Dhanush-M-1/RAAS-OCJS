a,b = [int(s) for s in input().split()]
p, t = 0, 0
while a > 0:
    a -= 1
    p += 1
    t += 1
    if p%b == 0:
        a += 1
        p = 0
print (t)