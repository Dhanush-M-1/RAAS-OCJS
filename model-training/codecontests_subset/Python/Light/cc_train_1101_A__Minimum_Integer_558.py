q = int(input())

result = []

for i in range(q):
    l, r, d = map(int, input().split())
    if d < l:
        result.append(d)
    elif d > r:
        result.append(d)
    else:
        c = (r//d)*d
        while c <= r:
            c += d
        result.append(c)

for i in result:
    print (i)
