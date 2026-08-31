a, b = map(int, input().split())

t = 0
c = 0
while a > 0:
    c += 1
    t += 1
    a -= 1
    if t == b:
        a +=1
        t = 0

print(c)
