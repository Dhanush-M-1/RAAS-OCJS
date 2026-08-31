a=int(input())
b=input().split()
n=0
s=0
k=0
for i in range(len(b)):
    n+=int(b[i])
    s+=1
    if int(b[i])>k:
        k=int(b[i])
m=0
kk=0
while m<n:
    m=0
    for i in range(a):
        m+=(kk-int(b[i]))
    if m>n:
        break
    else:
        kk+=1
if kk>k:
    print(kk)
else:
    print(k)
"""
for i in range(len(b)):
    n+=int(b[i])
    s+=1
    if int(b[i])>k:
        k=int(b[i])
kk=(n//s)*2+1
m=0
for i in range(a):
    m+=(kk-int(b[i]))
if m==n:
    kk+=1
if kk>k:
    print(kk)
else:
    print(k)
"""
