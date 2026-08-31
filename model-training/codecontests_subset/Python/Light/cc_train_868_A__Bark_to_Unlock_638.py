r=list(input())
a=[]
b=[]
t=0
for i in range(int(input())):
    p=list(input())
    if(p==r):
        t+=1
    a.append(p[0])
    b.append(p[1])

if((r[0] in b and r[1] in a)or t==1):
    print("YES")
else:
    print("NO")

