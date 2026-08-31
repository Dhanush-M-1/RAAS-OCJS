t=int(input())
while t>0:
    l,r,d=[int(x) for x in input().split()]
    if(d<l or d>r):
        print(d)
    else:
        print(((r//d)*d)+d)
    t-=1