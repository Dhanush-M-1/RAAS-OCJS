n=int(input(""))
l1=list(map(int,input("").split()))
l1.sort()
l2=list(map(int,input("").split()))
l2.sort()
l3=list(map(int,input("").split()))
l3.sort()
a=0
b=0
c=0
for i in range(0,len(l1)-1):
    if(l1[i]!=l2[i]):
        a=l1[i]
        c=1
        break
if(c==0):
    a=l1[len(l1)-1]
c=0
for i in range(0,len(l2)-1):
    if(l2[i]!=l3[i]):
        b=l2[i]
        c=1
        break
if(c==0):
    b=l2[len(l2)-1]
print(a)
print(b)
    
