n = int(input())
a = list(map(int, input().split()))

cnt = 0
for i in range(n):
    minj = i
    for j in range(i+1,n):
        if a[j]<a[minj]:
            minj = j
    if minj!=i:
        a[i], a[minj] = a[minj], a[i]
        cnt+=1

print(*a)
print(cnt)
