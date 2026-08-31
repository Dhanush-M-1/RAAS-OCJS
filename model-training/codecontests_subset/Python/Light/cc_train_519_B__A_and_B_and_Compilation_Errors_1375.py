input()
a = input().split()
a.sort()
b = input().split()
b.sort()
c = input().split()
c.sort()

b += ['']
c += ['', '']

for i, val in enumerate(a):
    if val != b[i]:
        print(val)
        break

for i, val in enumerate(b):
    if val != c[i]:
        print(val)
        break
