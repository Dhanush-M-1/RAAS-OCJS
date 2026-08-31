n=int(input())
r=n//11
b=list(input())
c=b.count('8')
#print(c,r)
if c>=r:
    print(r)
if c<r:
    print(c)