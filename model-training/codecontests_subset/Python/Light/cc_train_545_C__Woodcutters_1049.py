N = int(input())
A = [0] * N
B = [0] * N 
for i in range(N):
    A[i],B[i] = map(int, input().split())
ans = 2
for i in range(1,N-1):
    if(A[i] - A[i-1] > B[i]):
        ans+=1
    elif(A[i+1] - A[i] > B[i]):
        ans += 1
        A[i] += B[i]
if(N == 1):
    print(1)
else:
    print(ans)
