def main():
    
    n,k=list(map(int,input().split()))
    l=[]
    c1=0
    c2=0
    for j in range(0,n):
        l1=list(map(int,input().split()))
        if l1[1]==1:
            c1+=1
        if l1[2]==1:
            c2+=1
        l.append(l1)    
    if c1<k or c2<k:
        print(-1)
        return
    
    c=0
    d={}
    l2=[]
    l3=[]
    l4=[]
    for j in range(0,n):
        if l[j][1]==1 and l[j][2]==1:
            l4.append(l[j][0])
        elif l[j][1]==1:
            l2.append(l[j][0])
        elif l[j][2]==1:
            l3.append(l[j][0])
    
    m=10**9+7
    
    l2.append(m)
    l3.append(m)
    l4.append(m)
    l2.sort()
    l3.sort()
    l4.sort()
    #print(l2,l3,l4)
    p1=0
    p2=0
    p3=0
    f=0
    k1=k
    k2=k
    j=0
    while k1!=0 or k2!=0:
        if l2[p1]+l3[p2] >= l4[p3] and p3!=len(l4)-1:
            c+=l4[p3]
            
            if p3!=len(l4)-1:
                p3+=1
                
            k1-=1
            k2-=1
        
        else:
            if k1!=0 and p1!=len(l2)-1:
                c+=l2[p1]
                if p1!=len(l2)-1:
                    p1+=1
                k1-=1
            if k2!=0 and p2!=len(l3)-1:
                c+=l3[p2]
                if p2!=len(l3)-1:
                    p2+=1
                k2-=1
            
        if k1==0 and k2==0:
            break
        
    print(c)
        
        
            
    
    
            
t=1
for i in range(0,t):
    main()


    