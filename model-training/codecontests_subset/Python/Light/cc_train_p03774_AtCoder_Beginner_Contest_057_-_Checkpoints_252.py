f = lambda k:[list(map(int,input().split())) for _ in range(k)]
n,m = map(int,input().split())
lln = f(n)
llm = f(m)

for a,b in lln:
  mi,p = 10**9,m
  for i, [c,d] in enumerate(llm):
    di = abs(c-a)+abs(d-b)
    if di < mi:
      mi,p = di,i+1
  print(p)