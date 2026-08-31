n = int(input())
a = list(map(int, input().split()))
c = 0
flag = 0
for i in range(n):
    minv = i
    for j in range(i+1, n):
        if a[j]<a[minv]:
            minv = j
            flag = 1
    c += flag
    flag = 0
    a[i], a[minv] = a[minv], a[i]
print(*a)
print(c)

