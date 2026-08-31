a, b = map(int, input().split())
h = 0
c = 0

while(a > 0):
    h += 1
    a -= 1
    c += 1
    if c == b:
        a += 1
        c = 0

print(h)
