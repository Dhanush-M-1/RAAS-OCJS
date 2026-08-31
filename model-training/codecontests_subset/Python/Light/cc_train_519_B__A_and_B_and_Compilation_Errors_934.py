n=int(input())
a=[int(i) for i in input().split()]
b=[int(i) for i in input().split()]
c=[int(i) for i in input().split()]

x=sorted(a)
y=sorted(b)
z=sorted(c)

y.append(0)
q=[]
for i in range(n):
    q=y[i]-x[i]
    if q!=0:
        print(x[i])
        break

z.append(0)
z.append(0)
p=[]
for i in range(n-1): #注意范围啊啊啊
    p=z[i]-y[i]
    if p!=0:
        print(y[i])
        break