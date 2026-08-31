n = input()
a, b, c = {}, {}, {}
for i in input().split():
    j = int(i)
    if j in a:
        a[j] += 1
    else:
        a[j] = 1
for i in input().split():
    j = int(i)
    if j in b:
        b[j] += 1
    else:
        b[j] = 1
for i in a:
    if i not in b or a[i] != b[i]:
        print(i)
for i in input().split():
    j = int(i)
    if j in c:
        c[j] += 1
    else:
        c[j] = 1
for i in b:
    if i not in c or b[i] != c[i]:
        print(i)