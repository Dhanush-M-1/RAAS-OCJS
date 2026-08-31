def ans(l,l1):
    l.sort()
    l1.sort()
    k=list(set(l)&set(l1))
    k.sort()
    if(k):
        print("YES")
        if(len(k)>1):
            print(1,k[1])
        else:
            print(1,k[0])
    else:
        print("NO")
        
t=int(input())
while(t>0):
    a,b=map(int,input().split())
    
    l=list(map(int,input().split()))
    l1=list(map(int,input().split()))
    if(a==1 and b==1):
        if(l[0]==l1[0]):
            print("YES")
            print(1,l[0])
        else:
            print("NO")
    elif(l==l1):
        print("YES")
        print(1,l[1])
    else:
        ans(l,l1)
    t-=1