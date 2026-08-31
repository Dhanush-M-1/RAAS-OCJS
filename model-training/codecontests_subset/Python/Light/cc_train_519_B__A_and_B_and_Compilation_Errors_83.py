t=int(input())
a,b,c=list(map(int,input().split())),list(map(int,input().split())),list(map(int,input().split()))
result1,result2=None,None
a.sort()
b.sort()
c.sort()
for i in range(len(a)):
    if i==len(b):
        result1 = a[i]
    elif a[i]!=b[i]:
        result1=a[i]
        break
for i in range(len(b)):
    if i==len(c):
        result2 = b[i]
        
    elif b[i]!=c[i]:
        result2=b[i]
        break
print(result1)
print(result2)