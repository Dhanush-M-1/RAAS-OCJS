n = int(input())

def cal(x, y, z):
    cnt = 0
    while x > 0 and y > 1:
        x -= 1
        y -= 2
        cnt += 3
    while y > 0 and z > 1:
        y -= 1
        z -= 2
        cnt += 3
    return cnt
def calc(x, y, z):
    num = 0
    while y > 0 and z > 1:
        y -= 1
        z -= 2
        num += 3
    while x > 0 and y > 1:
        x -= 1
        y -= 2
        num += 3
    return num
for i in range(n):
    a, b, c = map(int, input().split())
    e, f, g = a, b, c
    t = cal(a, b, c)
    m = calc(e, f, g)
    print(max(t, m))
