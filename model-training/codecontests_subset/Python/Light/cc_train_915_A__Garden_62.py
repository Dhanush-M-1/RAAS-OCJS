p = list(map(int, input().split()))
a = list(map(int, input().split()))
a.sort(reverse=True)
i = 0
while i < p[0]:
    if p[1] % a[i] == 0:
        break
    i += 1
print(p[1] // a[i])
