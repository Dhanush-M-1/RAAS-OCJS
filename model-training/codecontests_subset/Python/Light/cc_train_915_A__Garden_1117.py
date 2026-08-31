n,k = map(int, input().split())
b = list(map(int,input().split()))
a = []
for i in range(n):
    if (k/b[i]).is_integer():
        a.append(k/b[i])
a = sorted(a)
print(int(a[0]))