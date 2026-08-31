r1,r2 = map(int,input().split())
c1,c2 = map(int,input().split())
d1,d2 = map(int,input().split())
a=[]
a.append((r1+c1-d2)//2)
a.append(r1-a[0])
a.append(d2-a[1])
a.append(d1-a[0])
if(len(set(a))!=4):
    print(-1)
    exit(0)
for i in a:
    if(i<1 or i>9):
        print(-1)
        exit(0)
if(a[0]+a[1]!=r1 or a[2]+a[3]!=r2 or a[0]+a[2]!=c1 or a[1]+a[3]!=c2 or a[0]+a[3]!=d1 or a[1]+a[2]!=d2):
    print(-1)
    exit(0)
print("{} {}\n{} {}".format(a[0],a[1],a[2],a[3]))