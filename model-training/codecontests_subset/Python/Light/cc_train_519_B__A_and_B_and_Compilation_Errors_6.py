n = int(input())
a = sorted(list(map(int, input().split())))
b = sorted(list(map(int, input().split())))
c = sorted(list(map(int, input().split())))
flag1 = True
for i in range(n - 1):
    if b[i] != a[i]:
        print(a[i])
        flag1 = False
        break
if flag1 == True:
    print(a[-1])
flag2 = True
for i in range(n - 2):
    if b[i] != c[i]:
        print(b[i])
        flag2 = False
        break
if flag2 == True:
    print(b[-1])