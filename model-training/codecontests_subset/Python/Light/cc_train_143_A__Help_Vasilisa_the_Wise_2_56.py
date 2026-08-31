
r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
flag=0
for i in range(1,10):
    l=[]
    x1=i
    y1=r1-x1
    x2=c1-x1
    y2=c2-y1
    if(0<y1<10  and 0<x2<10 and 0<y2<10 and d1==x1+y2 and d2==x2+y1 and y2==r2-x2):
        l.append(x1)
        l.append(y2)
        l.append(y1)
        l.append(x2)
        if(len(set(l))==4):
            flag=1
            print(x1,y1)
            print(x2,y2)
            break;
if(flag==0):
    print("-1")