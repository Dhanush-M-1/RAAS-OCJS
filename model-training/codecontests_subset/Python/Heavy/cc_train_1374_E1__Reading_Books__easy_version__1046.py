a,k = map(int,input().split())
l1=[]
l2=[]
l3=[]
for i in range(a):
    b,c,d = map(int,input().split())
    if(c==1 and  d==1):
        l3.append(b)
    elif(c==1):
        l1.append(b)
    elif(d==1):
        l2.append(b)
l1 = sorted(l1)
l2 = sorted(l2)
l3 = sorted(l3)
if((len(l1)+len(l3))<k or (len(l2)+len(l3))<k):
    print(-1)
else:
    d=0
    k1=0
    k2=0
    k3=0
    for i in range(k):
        if(len(l3)>k3 and (len(l1)>k1 and len(l2)>k2)):
            if(l3[k3]<(l1[k1]+l2[k2])):
                d+=l3[k3]
                k3+=1
            else:
                d+=l1[k1]+l2[k2]
                k1+=1
                k2+=1
        else:
            if(k3<len(l3)):
                d+=l3[k3]
                k3+=1
            else:
                d+=l1[k1]+l2[k2]
                k1+=1
                k2+=1
    print(d)
    
 
