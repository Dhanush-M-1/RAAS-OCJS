n,k=map(int, input().split())
alice=[]
bob=[]
both=[]
counta=0
countb=0
for i in range(0,n):
    l1=list(map(int, input().split()))
    if l1[1]==1 and l1[2]==1:
        counta+=1
        countb+=1
        both.append(l1)
    elif l1[1]==1:
        counta+=1
        alice.append(l1)
    elif l1[2]==1:
        countb+=1
        bob.append(l1)
    

if counta<k or countb <k:
    print (-1)
else:
    t=0
    alice.sort()
    bob.sort()
    both.sort()

    a=0
    b=0
    
    
    for i in range(1,k+1):
        if b>min(len(alice), len(bob))-1:
            for j in range(a,a+k-i+1):
                t=t+both[j][0]
            break
        if a>len(both)-1:
            for j in range(b,b+k-i+1):
                t=t+alice[j][0]+bob[j][0]
            break
        
        if both[a][0]<=alice[b][0]+bob[b][0]:
            t=t+both[a][0]
            a=a+1
        else:
            t=t+alice[b][0]+bob[b][0]
            b=b+1

    print (t)



