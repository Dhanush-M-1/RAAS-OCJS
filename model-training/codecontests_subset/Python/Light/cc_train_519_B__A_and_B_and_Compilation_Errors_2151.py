n = int(input())
a = [int(_) for _ in input().split()]
b = [int(_) for _ in input().split()]
c = [int(_) for _ in input().split()]

a.sort()
b.sort()
c.sort()

ea, eb = None, None


flag = False
for i in range(len(b)):
    if a[i] != b[i]:
        ea = a[i]
        flag = True
        break

if not flag:
    ea = a[-1]

flag = False
for i in range(len(c)):
    if b[i] != c[i]:
        eb = b[i]
        flag = True
        break

if not flag:
    eb = b[-1]


print(ea)
print(eb)

