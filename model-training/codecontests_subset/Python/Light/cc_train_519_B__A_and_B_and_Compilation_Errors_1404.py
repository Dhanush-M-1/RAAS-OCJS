n = int(input())
l1 = list(map(int,input().split()))
l2 = list(map(int,input().split()))
l3 = list(map(int,input().split()))
l1.sort()
l2.sort()
l3.sort()
i=0
j=0
k=0
p=0
o=0
while(j<len(l2)):
    if l1[i]!=l2[j]:
        print(l1[i])
        p=1
        break
    i+=1
    j+=1
if p==0:
    print(l1[-1])

j=0
while(k<len(l3)):
    if l2[j]!=l3[k]:
        print(l2[j])
        o=1
        break
    j+=1
    k+=1
if o==0:
    print(l2[-1])
