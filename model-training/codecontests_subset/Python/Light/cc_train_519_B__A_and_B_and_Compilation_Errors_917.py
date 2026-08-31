n = int(input())
a = list(map(int, input().split(' ')))
b = list(map(int, input().split(' ')))
c = list(map(int, input().split(' ')))
a.sort()
b.sort()
c.sort()
flag = 0
for i in range(n-1):
    if a[i] != b[i]:
        print(a[i])
        flag = 1
        break
if flag == 0:
    print(a[n-1])
flag = 0
for i in range(n-2):
    if b[i] != c[i]:
        print(b[i])
        flag = 1
        break
if flag == 0:
    print(b[n-2])
