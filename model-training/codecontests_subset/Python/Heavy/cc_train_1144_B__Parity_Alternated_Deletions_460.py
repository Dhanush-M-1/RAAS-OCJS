n=int(input())
l=list(map(int,input().strip().split(' ')))
l1=[]
l2=[]
summing=0
for i in l:
    if i%2==0:
        l1.append(i)
    else:
        l2.append(i)
    summing+=i
l1.sort(reverse=True)
l2.sort(reverse=True)
length1=len(l1)
length2=len(l2)
val=min(length1,length2)
new_sum=0
for i in range(val):
    new_sum+=l1[i]+l2[i]
if length1==length2:
    print(summing-new_sum)
else:
    if val==length1:
        new_sum+=l2[val]
    else:
        new_sum+=l1[val]
    print(summing-new_sum)
    
    
