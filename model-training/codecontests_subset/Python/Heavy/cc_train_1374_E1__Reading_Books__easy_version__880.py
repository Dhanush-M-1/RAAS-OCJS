def binary(a,start,end,e):
    mid=(start+end)//2
    if a[mid]==e:
        return mid
    elif a[mid]>e:
        end=mid-1
    else:
        start=mid+1
    if start<=end:
        return binary(a,start,end,e)
    else:
        return start
n,k=map(int,input().split())
p=[]
al=[]
bo=[]
for j in range(n):
    a,b,c=map(int,input().split())
    if b==1 and c==1:
        p.append(a)
    elif b==1 and c==0:
        al.append(a)
    elif b==0 and c==1:
        bo.append(a)
al.sort()
bo.sort()
if p!=[]:
    while al!=[] and bo!=[]:
        v=al[0]+bo[0]
        #q=binary(p,0,len(p)-1,v)
        p.append(v)
        del al[0]
        del bo[0]
else:
    while al!=[] and bo!=[]:
        v=al[0]+bo[0]
        p.append(v)
        del al[0]
        del bo[0]
p.sort()
if len(p)<k:
    print(-1)
else:
    print(sum(p[:k]))
    
