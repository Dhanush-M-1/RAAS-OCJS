def dels(x):
    y=[]
    for i in range(1, int(x**0.5)+2):
        if x%i==0:
            y.append(i)
            y.append(x//i)
    return list(set(y))

n=int(input())
a=[int(i) for i in input().split()]
x=0
for i in range(n):
    if a[i]>x:
        x=a[i]
x0=0
for i in range(n):
    if x>a[i]>x0:
        x0=a[i]

d=dels(x-x0)
for i in range(n):
    j=0
    while j<len(d):
        if (x-a[i])%d[j]>0:
            d.pop(j)
        else:
            j+=1
z=max(d)
y=0
for i in range(n):
    y+=(x-a[i])//z
print(y,z)
