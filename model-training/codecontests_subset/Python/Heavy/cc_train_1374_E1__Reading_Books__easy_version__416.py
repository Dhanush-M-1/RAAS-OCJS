n,k=map(int,input().split())
both=[]
alice=[]
bob=[]
none=[]
for i in range(n):
    t,a,b=map(int,input().split())
    if a==1 and b==1:
        both.append(t)
    elif a==1:
        alice.append(t)
    elif b==1:
        bob.append(t)
    else:
        none.append(t)
flag=0
both.sort()
alice.sort()
bob.sort()
if len(both)<k:
    if (len(alice)+len(both))<k or (len(bob)+len(both))<k:
        print(-1)
        flag=1
bothpt=0
bobpt=0
alicept=0
count=0
if flag==0:
    for i in range(k):
        # print(len(both),bothpt,len(alice),alicept,len(bob),bothpt)
        if alicept>=len(alice) or bobpt>=len(bob):
            count+=both[bothpt]
            bothpt+=1
            continue

        if bothpt<len(both) and both[bothpt]<=(alice[alicept]+bob[bobpt]):
            count+=both[bothpt]
            bothpt+=1
        else:
            count+=alice[alicept]+bob[bobpt]
            alicept+=1
            bobpt+=1
    print(count)