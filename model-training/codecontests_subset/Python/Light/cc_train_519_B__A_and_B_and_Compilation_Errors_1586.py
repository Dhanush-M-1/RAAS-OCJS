a=int(input())
b=input().split()
c=input().split()
d=input().split()
e=0
f=0
g=0
for i in range(a):
    e=e+int(b[i])
for j in range(a-1):
    f=f+int(c[j])
for k in range(a-2):
    g=g+int(d[k])
print(e-f)
print(f-g)