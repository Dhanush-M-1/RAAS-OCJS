t=int(input())
for  _ in range(t):
    n,l,r=map(int,input().split())
    L=[0]
    tt=2*(n-1)
    for i in range(n):
        L.append(tt)
        tt-=2
    L[-1]=1

    temp=0
    ct=r-l+1
    c=0

    tot=0
    for i in range(1,len(L)):
        if(tot+L[i]<l):
            tot+=L[i]
        else:
            rem=l-tot
            p1=i
            p2=rem//2
            if(rem%2!=0):
                p2+=1
                temp=1
            p2+=i
            break

    if(temp==0):
        print(p2,end=" ")
        p2+=1
        if(p2==n+1):
            p1+=1
            if(p1==n):
                p1=1
            p2=p1+1
        c+=1
    if(p1==n):
        p1=1
    while(c<ct):
        print(p1,end=" ")
        c+=1
        if(c==ct):
            break
        print(p2,end=" ")
        c+=1
        p2+=1
        if(p2==n+1):
            p1+=1
            if(p1==n):
                p1=1
            p2=p1+1


    print(" ")
            
        
    
        
