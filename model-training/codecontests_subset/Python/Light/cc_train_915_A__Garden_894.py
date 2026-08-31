n, k = map(int, input().split() )
a = sorted(list(map(int, input().split() ) ) )
r = -1
for i in range(len(a)-1, -1, -1):
    if k % a[i] == 0:
        r = k // a[i]
        break
print(r)
