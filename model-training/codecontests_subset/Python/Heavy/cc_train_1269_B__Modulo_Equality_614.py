"A"
'''
n=int(input())
if n%2==0:
    print(n+4,end=" ")
    print(4)
else:
    print(n+9,end=" ")
    print(9)
'''

n,m=map(int,input().split())
a=map(int,input().split())
a=list(a)
a.sort()
b=map(int,input().split())
b=list(b)
b.sort()
diffa=[0]*(n-1)
diffb=[0]*(n-1)
for i in range(n-1):
    diffa[i]=a[i+1]-a[i]
    diffb[i]=b[i+1]-b[i]
q=a[n-1]-a[0]
q=m-q
q=q%m
diffa.append(q)
arr=[]
if diffa[0:n-1]==diffb:
    x=b[0]-a[0]
    if x<0:
        x=x+m
    arr.append(x)
for i in range(n-1,0,-1):
    c1=i
    diff=[]
    for i1 in range(n-1):
        diff.append(diffa[c1])
        c1=c1+1
        if c1>n-1:
            c1=0
    if diff==diffb:
        x=b[0]-a[i]
        if x<0:
            x=x+m
        arr.append(x)
print(min(arr))


