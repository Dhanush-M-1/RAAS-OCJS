a, b = map(int, input().split())
t = 0
u = 0
while True:
    u += a
    t += a
    a = u // b
    u -= a*b
    if a == 0:
        print(t)
        break
