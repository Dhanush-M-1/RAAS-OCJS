n,ke=[int(i) for i in input().split()]
bo=[]
a1=[]
b1=[]
for i in range(n):
    ti,a,b=[int(i) for i in input().split()]
    if a==1 and b==1:
        bo.append([ti,a,b])
    elif a==1:
        a1.append([ti,a,b])
    elif b==1:
        b1.append([ti,a,b])
bo.sort()
a1.sort()
b1.sort()
su=0
i=0
j=0
k=0
f1=0
while ke>0:
    if i+1>len(bo) or (j+1>len(a1) or k+1>len(b1)):
        f1=1
        break
    elif bo[i][0]<=a1[j][0]+b1[k][0]:
        su+=bo[i][0]
        i+=1
        ke-=1
    elif bo[i][0]>a1[j][0]+b1[k][0]:
        su+=a1[j][0]+b1[k][0]
        ke-=1
        j+=1
        k+=1
    elif bo[i][0]==a1[j][0]+b1[k][0]:
        if len(bo)>=min(len(a1),len(b1)):
            su+=bo[i][0]
            i+=1
            ke-=1
        else:
            su+=a1[j][0]+b1[k][0]
            j+=1
            k+=1
            ke-=1
if ke>0 and i+1>len(bo) and (j+1>len(a1) and k+1>len(b1)):
    print(-1)
elif f1==0:
    print(su)
else:
    if i+1>len(bo):
        if (j+ke<=len(a1) and k+ke<=len(b1)):
            while ke>0:
                su+=a1[j][0]+b1[k][0]
                ke-=1
                j+=1
                k+=1
            print(su)
        else:
            print(-1)
    elif j+1>len(a1) or k+1>len(b1):
        if i+ke<=len(bo):
            while ke>0:
                su+=bo[i][0]
                i+=1
                ke-=1
            print(su)
        else:
            print(-1)
    else:
        print(-1)


