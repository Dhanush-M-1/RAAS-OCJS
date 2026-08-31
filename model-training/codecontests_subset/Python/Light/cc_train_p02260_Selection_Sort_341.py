n = int(input())
a = list(map(int, input().split()))
c = 0
for i in range(n - 1):
    j = a[i:].index(min(a[i:])) + i
    if i != j:
        a[i], a[j] = a[j], a[i]
        c += 1
print(" ".join(map(str, a)))
print(c)
