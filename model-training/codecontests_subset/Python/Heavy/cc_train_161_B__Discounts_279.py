l=input().split()
n=int(l[0])
k=int(l[1])
qofp=[]
qofs=[]
for i in range(n):
    l=input().split()
    if(int(l[1])==1):
        qofs.append((int(l[0]),i+1))
    else:
        qofp.append((int(l[0]),i+1))
qofs.sort()
qofs.reverse()
fina=[[] for i in range(k)]
if(len(qofs)<k):
    price=0
    i=0
    while(qofs!=[]):
        fina[i].append(qofs[0][1])
        price+=(qofs[0][0]*0.5)
        qofs.pop(0)
        i+=1
    for j in range(i,k-1):
        fina[j].append(qofp[0][1])
        price+=qofp[0][0]
        qofp.pop(0)
    for i in qofp:
        fina[k-1].append(i[1])
        price+=i[0]
    print("{:.1f}".format(price))
    for i in fina:
        print(len(i),end=" ")
        for j in i:
            print(j,end=" ")
        print()
else:
    price=0
    for i in range(k-1):
        fina[i].append(qofs[0][1])
        price+=(0.5*qofs[0][0])
        qofs.pop(0)
    fool=[]
    while(qofs!=[]):
        fina[k-1].append(qofs[0][1])
        fool.append(qofs[0][0])
        price+=qofs[0][0]

        qofs.pop(0)
    while(qofp!=[]):
        fina[k-1].append(qofp[0][1])
        fool.append(qofp[0][0])
        price+=qofp[0][0]
        qofp.pop(0)

    z=min(fool)
    price-=(z/2)
    print("{:.1f}".format(price))
    for i in fina:
        print(len(i),end=" ")
        for j in i:
            print(j,end=" ")
        print()