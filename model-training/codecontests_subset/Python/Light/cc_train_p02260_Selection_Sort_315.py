n = int(input())
a = [int(i) for i in input().split()]
cnt = 0
for i in range(n):
    minj = i
    for j in range(i,n):
        if a[j] < a[minj]:
            minj = j
    if i != minj:
        a[i], a[minj] = a[minj], a[i]
        cnt += 1
print(' '.join([str(i) for i in a]))
print(cnt)

