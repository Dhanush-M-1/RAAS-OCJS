a, b = [int(x) for x in input().split()]
c = 0
d = a
while c >= 0:
    if d//b > 0:
        c += d//b
        d = d//b + d%b
    else:
        break
print(a+c)
