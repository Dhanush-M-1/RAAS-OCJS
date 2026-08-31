n, k = map(int, input().split())
a, b, c, d = map(int, input().split())

if (k < n + 1 or n == 4):
    print(-1)
    exit()

v = [0 for i in range(n + 1)]
v[a] = v[b] = v[c] = v[d] = 1
e = f = 0
for i in range(1, n + 1):
    if not v[i] and not e:
        e = i
        v[i] = 1
        continue
    if not v[i] and e and not f:
        f = i
        v[i] = 1
if n == 5:
    print(a, c, e, d, b, sep = ' ')
    print(c, a, e, b, d, sep = ' ')
    exit()
a1 = [a, c, e]
for i in range(1, n + 1):
    if not v[i]:
        a1.append(i)
a1 += [f, d, b]
a2 = [c, a, e]
for i in range(1, n + 1):
    if not v[i]:
        a2.append(i)
a2 += [f, b, d]
print(' '.join(map(str, a1)))
print(' '.join(map(str, a2)))
