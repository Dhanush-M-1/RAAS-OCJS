n = int(input())
a = list(map(int, input().split()))


count = 0

for i in range(n):
    m = i
    for j in range(i+1, n):
        if a[j] < a[m]:
            m = j
    a[i], a[m] = a[m], a[i]
    if i != m:
        count += 1

print(' '.join(map(str, a)))
print(count)

