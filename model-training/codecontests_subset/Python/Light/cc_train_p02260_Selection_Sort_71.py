N = int(input())
A = list(map(int,input().split()))
cnt = 0
for i in range(N):
    minj = i
    for j in range(i+1,N):
        if A[j] < A[minj]:
            minj = j
    if i != minj:
        A[i],A[minj] = A[minj],A[i]
        cnt += 1
print(*A)
print(cnt)

