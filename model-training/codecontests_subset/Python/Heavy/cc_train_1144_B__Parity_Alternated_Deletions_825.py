a=int(input())
z=list(map(int,input().split()))
odd=[]
eve=[]
for i in range(len(z)):
    if(z[i]%2==1):
        odd.append(z[i])
    else:
        eve.append(z[i])
odd.sort(reverse=True)
eve.sort(reverse=True)
arr1=[]
arr2=[]
l1=0
l2=0
i=0
while(l1<len(odd) and l2<len(eve)):
    if(i%2==1):
        arr1.append(odd[l1])
        l1+=1
    else:
        arr1.append(eve[l2])
        l2+=1
    i+=1
if(l1==len(odd) and l2<len(eve)):
    arr1.append(eve[l2])
if(l1<len(odd) and l2==len(eve)):
    arr1.append(odd[l1])
    
l1=0
l2=0
i=0
while(l1<len(odd) and l2<len(eve)):
    if(i%2==1):
        arr2.append(eve[l2])
        l2+=1
    else:
        arr2.append(odd[l2])
        l1+=1
    i+=1
if(l1==len(odd) and l2<len(eve)):
    arr2.append(eve[l2])
if(l1<len(odd) and l2==len(eve)):
    arr2.append(odd[l1])
    
total=sum(z)

print(min(total-sum(arr1),total-sum(arr2)))

    
