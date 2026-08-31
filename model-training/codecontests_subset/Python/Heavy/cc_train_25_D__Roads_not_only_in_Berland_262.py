def way(v):
    if vertices[v] == v:
        return v
    else:
        vertices[v] = way(vertices[v])
        return vertices[v]


n = int(input())
vertices = [i for i in range(n + 1)]
useless = []
useful = []
for i in range(n - 1):
    a, b = map(int, input().split())
    v, u = a, b
    a = way(a)
    b = way(b)
    if a == b:
        useless.append((v, u))
    else:
        vertices[max(a, b)] = min(a, b)
        
used = set()
previous = 0
for i in range(1, n + 1):
    a = way(i)
    if a not in used:
        used.add(a)
        if previous:
            useful.append((previous, i))
        previous = i

print(len(useful))
for i in range(len(useful)):
    a, b = useless.pop()        
    a1, b1 = useful.pop()
    print(a, b, a1, b1) 