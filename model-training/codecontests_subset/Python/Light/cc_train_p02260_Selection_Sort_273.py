n, a, c = int(input()), list(map(int, input().split())), 0

for i in range(n):
    minj = i
    for j in range(i, n):
        if a[j] < a[minj]:
            minj = j
    if minj != i:
        a[i], a[minj], c = a[minj], a[i], c + 1

print(*a)
print(c)