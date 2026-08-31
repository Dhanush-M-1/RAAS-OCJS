N,M=map(int,input().split())
s=[list(map(int,input().split())) for _ in range(N)]
c=[list(map(int,input().split())) for _ in range(M)]
for i in range(N):
  d=10**9
  n=0
  for j in range(M):
    x=abs(s[i][0]-c[j][0])+abs(s[i][1]-c[j][1])
    if x<d:
      d=x
      n=j+1
  print(n)