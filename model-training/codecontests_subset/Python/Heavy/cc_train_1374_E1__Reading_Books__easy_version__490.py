t,k = map(int,input().split())
arra = []
arrb =  []
arrc =[]
ans =0
for i in range(t):
    a,b,c =map(int,input().split())
    if b==c==1 :
        arra.append(a)
    elif b==0 and c==1:
        arrc.append(a)
    elif b==1 and c==0:
        arrb.append(a)
arra.sort()
arrb.sort()
arrc.sort()    
l1,l2,l3 = len(arra),len(arrb),len(arrc)
#print(arra,arrb,arrc)
if min(l2,l3)<k and k-min(l2,l3)>l1:
    print(-1)
else:
    x = k
    y = k
    index =0
    curr  =0
    while(x!=0 or y!=0):
        s1 = 0
        Flag =True
        if curr<l2:
            s1+=arrb[curr]
        else:
            Flag =False
        if curr<l3:
            s1+=arrc[curr]
        else:
            Flag=False
        if (index<l1 and s1>arra[index]) or Flag ==False:
            ans+=arra[index]
            index+=1
            x-=1
            y-=1
        else:
            ans+=arrb[curr]
            ans+=arrc[curr]
            curr+=1
            x-=1
            y-=1
    print(ans)