
n,k=list(map(int,input().split()))
both=[]
alice=[]
bob=[]

for i in range(n):
    t,a,b=list(map(int,input().split()))
    if a==1 and b==1:
        both.append(t)
    elif a==1:
        alice.append(t)
    elif b==1:
        bob.append(t)
both.sort();alice.sort();bob.sort()
x=0;y=0
if len(both)+len(alice)<k or len(both)+len(bob)<k:
    print(-1)
else:
    both.append(10**9);alice.append(10**9);bob.append(10**9)

    i = 0;
    j = 0
    time=0
    alpha=0
    while x<k and y<k:
        if i<len(both) and j<len(alice) and alpha<len(bob):
            if both[i]<=alice[j]+bob[alpha]:
                time+=both[i]
                i+=1
                x+=1;y+=1
            else:
                time+=alice[j]+bob[alpha]
                j+=1
                alpha+=1
                x+=1;y+=1
        else:
            if len(both)!=i:
                if len(alice)==0:
                    if len(bob)==0:
                        time+=both[i]
                        i+=1
                        x+=1;y+=1

    print(time)
