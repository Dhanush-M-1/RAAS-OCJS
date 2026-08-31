for _ in range(int(input())):
    d={}
    for i in range(97,123):
        d[chr(i)]=0
    #print(d)
    n,m=map(int,input().split())
    a=input()
    p=list(map(int,input().split()))
    l1=[]
    for i in range(n):
        l1.append(0)
    for i in p:
        l1[0]+=1
        l1[i]-=1
    for i in range(1,len(l1)):
        l1[i]=l1[i]+l1[i-1]
    for i in range(len(l1)):
        l1[i]+=1
    for i in range(len(l1)):
        d[a[i]]+=l1[i]
    for i in d:
        print(d[i],end=" ")
    print()
            
    
    
        
