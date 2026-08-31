a, b = (int(x) for x in input().split())
t = 0
bo = 0

while a > 0:
    a -= 1
    bo += 1
    if bo == b:
        a += 1
        bo = 0
    t += 1

print(t)