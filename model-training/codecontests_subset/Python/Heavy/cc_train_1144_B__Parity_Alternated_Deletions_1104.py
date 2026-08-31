# cook your dish here
n=int(input())
nn=list(map(int,input().rstrip().split()))
arrev=[]
arrod=[]
for i in nn:
    if i%2==0:
        arrev.append(i)
    else:
        arrod.append(i)
#print(arrev,arrod)
arrev.sort(reverse=True)
arrod.sort(reverse=True)
#print(arrev,arrod)
lenev=len(arrev)
lenod=len(arrod)
#print(lenod,lenev)
if lenod==lenev:
    #print('b')
    print(0)
elif abs(lenev-lenod)==1:
    print(0)
    #print('c')
elif lenev>lenod:
    #print('a')
    arrrem=arrev[lenod+1:]
    print(sum(arrrem))
elif lenod>lenev:
    arrrem=arrod[lenev+1:]
    print(sum(arrrem))
    

    