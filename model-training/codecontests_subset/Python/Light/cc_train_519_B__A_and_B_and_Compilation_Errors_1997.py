n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))
a.sort()
b.sort()
c.sort()
for i in range(len(a)):
    if(i == len(a) - 1 or a[i] != b[i]):
        print(a[i])
        break
for i in range(len(b)):
    if(i == len(b) - 1 or b[i] != c[i]):
        print(b[i])
        break