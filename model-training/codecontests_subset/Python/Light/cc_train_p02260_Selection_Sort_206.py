N = int(input())
*A ,=map(int,input().split())
count =0
for i in range(N):
    mini = i
    for j in range(i+1,N):
        if A[j] <A[mini]:
            mini = j
    A[mini],A[i] = A[i],A[mini]
    if (mini != i):count +=1
print(' '.join(list(map(str,A))))
print(count)
