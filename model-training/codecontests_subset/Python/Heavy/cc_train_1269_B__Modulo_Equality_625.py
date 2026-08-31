def inp():
    return map(int, input().split())


n, m = inp()
b = list(inp())
a = list(inp())

a.sort()
b.sort()
b += b

# print(a)
# print(b)

for i in range(n):
    k = (a[0] - b[i])
    # print(a)
    # print(b[i:i+n])
    # print(f'k: {k}')
    res = True
    for j in range(i + 1, i + n):
        x = a[j - i] - b[j]
        y = a[j - i] - b[j] + m
        z = a[j - i] - b[j] - m

        # print(x, y, z)
        if x != k and y != k and z != k:
            res = False
            break
    if res:
        print(k if k >= 0 else m + k)
        break



