n=int(input())
s1=input()
s2=input()
s3=input()
p1=list(s1.split())
p2=list(s2.split())
p3=list(s3.split())
l1=[]
l2=[]
l3=[]
for i in p1:
    l1.append(int(i))
for i in p2:
    l2.append(int(i))
for i in p3:
    l3.append(int(i))
l1.sort()
l2.sort()
l3.sort()

for i in range(len(l1)-1):
    if l1[i]!=l2[i]:
        x1=int(l1[i])
        break
else:
    x1=int(l1[len(l1)-1])
for i in range(len(l2)-1):
    if l2[i]!=l3[i]:
        x2=int(l2[i])
        break
else:
    x2=int(l2[len(l2)-1])
print(x1,x2,sep='\n')