n, k = map(int, input().split())
a = list(map(int, input().split()))
mb = []
for i in range(n):
    if k % a[i] == 0:
        mb.append(k // a[i])
print(min(mb))