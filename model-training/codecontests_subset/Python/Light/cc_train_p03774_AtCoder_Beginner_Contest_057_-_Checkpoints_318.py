N,M = map(int,input().split())
A = [list(map(int,input().split())) for n in range(N)]
C = [list(map(int,input().split())) for m in range(M)]


for n in range(N):
  ans = []
  for m in range(M):
    ans.append(abs(A[n][0]-C[m][0])+abs(A[n][1]-C[m][1]))
  print(ans.index(min(ans))+1)