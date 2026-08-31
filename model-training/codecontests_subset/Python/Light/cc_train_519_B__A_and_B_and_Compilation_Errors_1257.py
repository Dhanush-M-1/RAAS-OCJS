n=int(input())
v=[int(i) for i in input().split()]
v2=[int(i) for i in input().split()]
v3=[int(i) for i in input().split()]
i,f=0,0
v.sort()
v2.sort()
v3.sort()
while(i<n-1):
    if(v[i]!=v2[i]):
        print(v[i])
        f=1
        break
    i=i+1
if(f==0):
    print(v[-1])

i,f=0,0
while(i<n-2):
    if(v2[i]!=v3[i]):
        print(v2[i])
        f=1
        break
    i=i+1
if(f==0):
    print(v2[-1])
