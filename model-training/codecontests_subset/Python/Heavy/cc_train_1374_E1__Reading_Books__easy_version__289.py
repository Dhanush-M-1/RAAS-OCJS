n,k=map(int,input().split())
lst=[]
for i in range(n):
    lst.append(list(map(int,input().split())))
alice=[]
bob=[]
same=[]
for i in lst:
    if i[1]==1 and i[2]==0:
        alice.append(i[0])
    elif i[2]==1 and i[1]==0:
        bob.append(i[0])
    elif i[2]==1 and i[1]==1:
        same.append(i[0])
a=len(alice)
b=len(bob)
s=len(same)
if a+s<k or b+s<k:
    print(-1)
else:
    alice.sort()
    bob.sort()
    same.sort()
    l=0
    n=0
    ans=0
    count=0
    temp=min(a,b)
    while count<k and n<s and l<temp:
        if alice[l]+bob[l]<same[n] or n>=s:
            ans+=alice[l]+bob[l]
            l+=1
            count+=1
            #print('here')
        else:
            ans+=same[n]
            count+=1
            n+=1
            #print('here2')
    if count!=k and n==s:
        ans+=sum(alice[l:l+k-count])+sum(bob[l:l+k-count])
    else:
        ans+=sum(same[n:n+k-count])
    print(ans)
