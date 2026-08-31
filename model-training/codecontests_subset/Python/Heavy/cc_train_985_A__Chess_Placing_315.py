n = int(input())
a = [0] * n
pos = list(map(int, input().split()))
for i in range(n // 2):
    a[pos[i] - 1] = 1

ans1 = 0
for i in range(n - 1):
    if i % 2 == 0:
        j = i
        while a[j] == 0:
            j += 1
        a[j] = 0
        ans1 += (j - i)
        a[i] = 1
    else:
        j = i
        while a[j] == 1:
            j += 1
        a[j] = 1
        ans1 += (j - i)
        a[i] = 0

a = [0] * n
for i in range(n // 2):
    a[pos[i] - 1] = 1

ans2 = 0
for i in range(1, n):
    if i % 2 == 1:
        j = i
        while a[-j] == 0:
            j += 1
        a[-j] = 0
        ans2 += (j - i)
        a[-i] = 1
    else:
        j = i
        while a[-j] == 1:
            j += 1
        a[-j] = 1
        ans2 += (j - i)
        a[-i] = 0

print(min(ans1, ans2))
