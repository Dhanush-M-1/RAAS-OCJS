n = int(input())
a = list(map(int, input().split()))
t = 0

for i in range(n):
    minj = i
    for j in range(i, n):
        if a[j] < a[minj]:
            minj = j
    a[i], a[minj] = a[minj], a[i]
    if i != minj:
        t += 1

print(' '.join(map(str, a)))
print(t)
