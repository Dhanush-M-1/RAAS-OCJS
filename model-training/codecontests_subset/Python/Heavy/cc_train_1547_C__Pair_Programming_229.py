for _ in range(int(input())):
    #n=int(input())
    s=input()
    k=0
    n,a,b=list(map(int,input().split()))
    l1=list(map(int,input().split()))
    l2=list(map(int,input().split()))
    d=max(max(l1),max(l2))+1
    l1.append(d)
    l2.append(d)
    i=0
    j=0
    l=[]
    while(i+j<a+b):
        if(l1[i]<=l2[j]):
            if(l1[i]<=n):
                l.append(l1[i])
                if(l1[i]==0):
                    n+=1
                i+=1
            else:
                k=1
                break
        elif(l1[i]>l2[j]):
            if(l2[j]<=n):
                l.append(l2[j])
                j+=1
                if(l2[j-1]==0):
                    n+=1
            else:
                k=1
                break
        else:
            k=1
            break
    if(k):
        print(-1)
    else:
        print(*l)
        
        
    

