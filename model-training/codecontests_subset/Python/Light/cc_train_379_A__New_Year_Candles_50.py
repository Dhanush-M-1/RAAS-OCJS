a, b = map(int,input().split())
t = a
r = 0
while (a + r) >= b:
    a, r = (a + r) // b, (a + r) % b
    t += a
print(t)