def sum(a):
    s=0
    for i in a:
        s=s+i
    return s
n=int(input())
a=list(input())
b=['0','1','2','3','4','5','6','7','8','9']
c=[0,0,0,0,0,0,0,0,0,0]
d=dict(zip(b,c))
for i in range(len(a)):
    d[a[i]]+=1
e=list(d.values())
z=sum(e)//11
x=e[8]
print(min(x,z))