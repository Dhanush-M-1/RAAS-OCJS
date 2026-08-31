n=int(input())
n1=[int(i) for i in input().split(' ')]
n2=[int(i) for i in input().split(' ')]
n3=[int(i) for i in input().split(' ')]
n1.sort()
n2.sort()
n3.sort()
x=[]
z=[]
for i in range(n-1):
    if n1[i]!=n2[i]:
        x.append(n1[i])
        break
if(len(x)==0):
    x.append(n1[n-1])

for i in range(n-2):
    if n3[i]!=n2[i]:
        z.append(n2[i])
        break
if(len(z)==0):
    z.append(n2[n-2])
print(x[0])
print(z[0])














# print(n,n1,n2,n3)

