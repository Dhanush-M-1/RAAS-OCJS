n = int(input())
a = list(map(int, input().strip().split()))
count = 0
for i in range(n):
    mini = i
    for j in range(i, n):
        if a[j] < a[mini]:
            mini = j
    if i != mini:
        count += 1
        a[i], a[mini] = a[mini], a[i]
print(' '.join(map(str, a)))
print(count)