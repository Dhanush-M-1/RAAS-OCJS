a, b = map(int, input().split())
h = 0
while a > 0:
    h += 1
    a -= 1
    if h % b == 0:
        a += 1
print(h)