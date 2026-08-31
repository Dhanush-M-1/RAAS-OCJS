n=int(input())
a=[]
a=[int(x) for x in input().split()]
b=[]
b=[int(x) for x in input().split()]
c=[]
c=[int(x) for x in input().split()]

a.sort()
b.sort()
c.sort()

l=[]

i=0
j=0
while j<n-1:
    if a[i]!=b[j]:
        l.append(a[i])
        break
    else:
        i=i+1
        j=j+1
    
if(len(l)==0):
    l.append(a[n-1])
i=0
j=0
while j<n-2:
    if b[i]!=c[j]:
        l.append(b[i])
        break
    else:
        i=i+1
        j=j+1
if(len(l)==1):
    l.append(b[n-2])  

for x in l:
    print(x)