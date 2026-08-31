t=int(input())
while t:
    
    x,l2=input().split()
    n1=len(x)
    l1=[]
    n2=len(l2)
    n=min(n1,n2)
    l=list(x)
    for i in range(n1):
        l1.append(x[i])
    l.sort()
    ch=0
    #print(l,l1)
    for i in range(n1):
        if l[i]!=l1[i]:
            index1=i
            ch=1
            for j in range(n1-1,-1,-1):
                if l[index1]==l1[j]:
                    index2=j
             #       print(index1,index2)
                    break
            break    
    if ch==1:
        k=l1[index2]
        l1[index2]=l1[index1]
        l1[index1]=k
    cnt=0    
    for i in range(n):
        if l1[i]==l2[i]:
            cnt+=1
    if cnt==n:
        if n1<n2:
            for r in range(n1):
                print(l1[r],end="")
            print()
        else:
            print("---")
    else:
        ch=0
        ans=0
        for i in range(n):
            if l1[i]<l2[i]:
                cnt1=0
                for j in range(i):
                    if l1[j]==l2[j]:
                        cnt1+=1 
                if cnt1==i:
                    ans=1
                    for r in range(n1):
                        print(l1[r],end="")
                    print()    
                    break
        if ans==0:
            print("---")
            
    t-=1