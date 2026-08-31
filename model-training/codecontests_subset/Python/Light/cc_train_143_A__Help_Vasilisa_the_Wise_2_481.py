I=lambda:map(int,input().split())
R=list(range(1,10))
P=print
q,w=I()
e,r=I()
t,y=I()
z=[(a,b,c,d)for a in R for b in R for c in R for d in R if len(set((a,b,c,d)))>3 and a+b==q and c+d==w and a+c==e and b+d==r and a+d==t and b+c==y]
if z:z=z[0];P(z[0],z[1]);P(z[2],z[3])
else:P(-1)