n=int(input())
x=-1
y=-1
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))

a.sort()
b.sort()
c.sort()
#print("",a,'\n',b,'\n',c)
for i in range(n-1):
    if x==-1 and a[i] != b[i]:
        x=a[i]
    if y==-1 and i<n-2 and b[i] != c[i] :
        y=b[i]
        
if x==-1:
    x=a[n-1]

if y==-1:
    y=b[n-2]
print(x)
print(y)
"""
5
1 5 8 123 7
123 7 5 1
5 1 7
outputCopy
8
123
inputCopy
6
1 4 3 3 5 7
3 7 5 4 3
4 3 7 5
outputCopy
1
3
"""