from collections import deque

def updiv(a,b):
    if a % b == 0:
        return a // b
    else:
        return a // b + 1

H,W,K = map(int,input().split())

A = []

for i in range(H):

    a = list(input())
    A.append(a)

q = deque([])

#print (A)

for i in range(H):

    for j in range(W):

        if A[i][j] == "S":
            q.append([i,j])
            A[i][j] = 0

while len(q) > 0:

    now = q.popleft()
    ni = now[0]
    nj = now[1]

    if A[ni][nj] < K:
        if ni-1 >= 0 and A[ni-1][nj] != "#":
            if A[ni-1][nj] == "." or A[ni][nj]+1 < A[ni-1][nj]:
                A[ni-1][nj] = A[ni][nj] + 1
                q.append([ni-1,nj])

        if ni+1 < H and A[ni+1][nj] != "#":
            if A[ni+1][nj] == "." or A[ni][nj]+1 < A[ni+1][nj]:
                A[ni+1][nj] = A[ni][nj] + 1
                q.append([ni+1,nj])

        if nj-1 >= 0 and A[ni][nj-1] != "#":
            if A[ni][nj-1] == "." or A[ni][nj]+1 < A[ni][nj-1]:
                A[ni][nj-1] = A[ni][nj] + 1
                q.append([ni,nj-1])

        if nj+1 < W and A[ni][nj+1] != "#":
            if A[ni][nj+1] == "." or A[ni][nj]+1 < A[ni][nj+1]:
                A[ni][nj+1] = A[ni][nj] + 1
                q.append([ni,nj+1])

ans = float("inf")
#print (A)

for i in range(H):

    for j in range(W):

        if A[i][j] not in [".","#"]:
            ans = min(ans , 1 + updiv(i,K) , 1 + updiv(j,K) , 1 + updiv(H-i-1,K), 1 + updiv(W-j-1, K))

print (ans)
