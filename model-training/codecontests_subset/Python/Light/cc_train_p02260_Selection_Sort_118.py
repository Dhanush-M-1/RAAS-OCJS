N = int(input())
a = [int(i) for i in input().split()]
count = 0
for i in range(N):
    minj = i
    for j in range(i,N):
        if a[j] < a[minj]:
            minj = j
    if i != minj:
        count += 1
        a[i], a[minj] = a[minj], a[i]
print(" ".join(map(str, a)))
print(count)