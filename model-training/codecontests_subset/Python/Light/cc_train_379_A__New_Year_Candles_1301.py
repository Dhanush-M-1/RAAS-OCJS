a, b = list(map(int, input().split()))
h = 1
lo = 0
while True:
    a -= 1
    lo += 1
    if lo == b:
        a += 1
        lo = 0
    if a == 0:
        print(h)
        break
    h += 1