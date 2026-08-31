n,m=map(int,input().split())
p=[list(map(int,input().split()))for _ in range(n)]
s=[list(map(int,'0'*m))for _ in range(n)]
for j in range(m):
  c,d=map(int,input().split())
  for i in range(n):
    s[i][j]=abs(p[i][0]-c)+abs(p[i][1]-d)
else:
  for i in range(n):print(1+s[i].index(min(s[i])))
