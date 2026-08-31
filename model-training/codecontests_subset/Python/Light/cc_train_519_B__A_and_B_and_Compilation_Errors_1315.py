# a = sorted(list(map(int, input().split())))
# print(a)
zxc = input()
a = list(map(int, input().split()))
a.sort()
b = list(map(int, input().split()))
b.sort()
c = list(map(int, input().split()))
c.sort()

i = 0
l = []

for x in b:
    if x != a[i]:
        break
    i += 1
l.append(a[i])
i = 0

for x in c:
    if x != b[i]:
        break
    i += 1
l.append(b[i])

print(l[0], l[1], sep="\n")
