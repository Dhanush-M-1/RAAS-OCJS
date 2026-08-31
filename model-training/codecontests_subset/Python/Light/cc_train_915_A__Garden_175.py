n, k=[int(i) for i in input().split()]
a=[int(i) for i in input().split()]
b=[]
for i in a:
    if k%i==0:
        b.append(i)
m=b[0]
for i in b:
    if i>m:
        m=i
print(k//m)