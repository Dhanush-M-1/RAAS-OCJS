import itertools
r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
l=list(range(1,10))
c=itertools.permutations(l,4)
f=0
for i in c:
    #print(i)
    if((i[0]+i[1]==r1) and (i[2]+i[3]==r2) and (i[0]+i[2]==c1) and (i[1]+i[3]==c2) and (i[0]+i[3]==d1) and (i[1]+i[2]==d2)):
        print(i[0],i[1])
        print(i[2],i[3])
        f=1
        break
if(f==0):
    print(-1)