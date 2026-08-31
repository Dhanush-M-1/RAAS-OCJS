n=int(input())
alist=list(map(int,input().split()))
blist=list(map(int,input().split()))
clist=list(map(int,input().split()))
a=sum(alist)
b=sum(blist)
c=sum(clist)
mlist=[]
mlist.append(a-b)
mlist.append(b-c)
for i in mlist:
    print(i)