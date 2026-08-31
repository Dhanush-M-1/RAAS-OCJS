t=int(input())
while t>0:
    li=input().split()
    l=int(li[0])
    r=int(li[1])
    d=int(li[2])
    if(d<l or d>r):
        print(d)
    else:
        print(((r//d)*d)+d)
    t-=1