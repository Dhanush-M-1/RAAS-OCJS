n = int(input())
L = list(map(int, input().split()))
p = 0
for i in range(n):
    minj = i
    for j in range(i, n):
        if L[j] < L[minj]:
            minj = j
    if i != minj: 
        L[i], L[minj] = L[minj], L[i]
        p += 1

print(*L)
print(p)