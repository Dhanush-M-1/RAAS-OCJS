a, b = map(int, input().split())
s = 0
r = 0
while a:
    s += a
    q = (a + r) // b
    r = (a + r) % b
    a = q
print(s)