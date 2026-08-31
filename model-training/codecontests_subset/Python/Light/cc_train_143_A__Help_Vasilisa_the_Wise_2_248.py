F=lambda : map(int, input().split())
R=list(range(1, 10))
r1,r2=F()
c1,c2=F()
d1,d2=F()
z = [(a,b,c,d) for a in R  for b in R for c in R for d in R if len(set((a,b,c,d))) > 3 and a+b == r1 and c+d == r2 and a+c == c1 and b+d == c2 and a+d == d1 and b+c == d2]
if z:z=z[0];print(z[0],z[1]);print(z[2],z[3])
else:print(-1)

