def check(x, y, z, w):
    if x + y == r1 and z + w == r2 and x + z == c1 and y + w == c2 and x + w == d1 and y + z == d2:
        return True
    else:
        return False

def equal(x, y, z, w):
    if x != y and x != z and x != w and y != z and y != w and z != w:
        return True
    else:
        return False

r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())

f = True

for a in range(1, 10):
    for b in range(1, 10):
        for c in range(1, 10):
            for d in range(1, 10):
                if check(a, b, c, d) and equal(a, b, c, d):
                    f = False
                    print(a, b)
                    print(c, d)
                    break
            if not f:
                break
        if not f:
            break
    if not f:
        break
    
if f:
    print(-1)
