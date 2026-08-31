n,m=map(int,input().split())
a=[int(x) for x in input().split()]
b=[int(x) for x in input().split()]

l=sorted(b)

A=sorted(list(set(a)))
B=sorted(list(set(b)))

#print(A)
#print(B)

ans=m-1
for i in range(0,len(B)):
    k=abs(B[i]-A[0])

    #print(k)

    h=[]
    for j in range(0,len(a)):
        h.append((a[j]+k)%m)

    if(sorted(h)==l):
        ans=min(ans,k)

    k2=m-abs(B[i]-A[0])

    #print(k)

    h=[]
    for j in range(0,len(a)):
        h.append((a[j]+k2)%m)

    if(sorted(h)==l):
        ans=min(ans,k2)

print(ans)
        
    
    

