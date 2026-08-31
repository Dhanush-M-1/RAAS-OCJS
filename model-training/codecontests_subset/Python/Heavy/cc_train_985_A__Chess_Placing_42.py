
n = int(input())
l = list(map(int,input().split()))
odd=0
even=0
c=0
l.sort()
for i in l:
    if i%2==0:
        even+=1
    else:
        odd+=1
g=[]
p=0
a=0
for i in range(1,n+1):
    if i%2==a and i not in l:
        g.append(i)
for i in l:
    if i%2!=a:
        if len(g)>0:

            c+=abs(g[0]-i)
        else:
            c=999999999
            break
        g.pop(0)


b=1
d=0
g=[]

for i in range(1,n+1):
    if i%2==b and i not in l:
        g.append(i)
for i in l:
    if i%2!=b:
        if len(g)>0:

            d+=abs(g[0]-i)
        else:
            d=9999999999
            break
        g.pop(0)
print(min(c,d))



