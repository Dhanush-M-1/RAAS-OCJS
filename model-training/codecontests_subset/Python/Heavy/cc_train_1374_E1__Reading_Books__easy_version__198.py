n, k = map(int, input().split())

d = {"a": [], "b": [], "c": []}

for _ in range(n):
    t, a, b = map(int, input().split())

    if (a, b) == (1, 0):
        d["a"].append(t)
    if (a, b) == (0, 1):
        d["b"].append(t)
    if (a, b) == (1, 1):
        d["c"].append(t)


d["a"].sort()
d["b"].sort()
d["c"].sort()

a = d["a"]
b = d["b"]
c = d["c"]

a1 = [0]
b1 = [0]
c1 = [0]

num = 0
for el in a:
    num += el
    a1.append(num)

num = 0
for el in b:
    num += el
    b1.append(num)

num = 0
for el in c:
    num += el
    c1.append(num)

if len(a) + len(c) < k or len(b) + len(c) < k:
    print(-1)

else:
    times = []
    i = 0
    while i <= k:
        try:
            temp = c1[i] + a1[k - i] + b1[k - i]
            times.append(temp)
        except IndexError:
            pass
        finally:
            i += 1

    print(min(times))
