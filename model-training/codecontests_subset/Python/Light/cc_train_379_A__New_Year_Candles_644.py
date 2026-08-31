a, b = map(int, input().split())
t = 0
e = 0
while a > 0 :
    t += 1
    a -= 1
    e += 1
    if e == b :
        a += 1
        e = 0
print(t)
    