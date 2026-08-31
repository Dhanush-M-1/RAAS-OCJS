n=int(input())
l1=[int(x) for x in input().split()]
l2=[int(x) for x in input().split()]
l3=[int(x) for x in input().split()]
l1=sorted(l1)
l2=sorted(l2)
l3=sorted(l3)
flag1,flag2=0,0
for i in range(len(l2)):
    if l1[i]!=l2[i]:
        print(l1[i])
        flag1=1
        break
if flag1==0:
    print(l1[-1])
for i in range(len(l3)):
    if l3[i]!=l2[i]:
        print(l2[i])
        flag2=1
        break
if flag2==0:
    print(l2[-1])




