n, k = map(int, input().split())
a = list(map(int, input().split()))
a.sort()
a = a[::-1]
for i in range(n):
    if (k % a[i] == 0):
        print(k // a[i])
        break