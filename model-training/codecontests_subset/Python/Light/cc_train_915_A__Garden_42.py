# A

n, k = map(int, input().split())

a = input().split()

for i in range(n):
    a[i] = int(a[i])

a.sort(reverse=True)

for i in range(n):
    if k % a[i] == 0:
        print(int(k/a[i]))
        break

