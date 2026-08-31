n,m=map(int,input().split())
arr=[]
b=[i for i in range(1,m+1)]
for i in range(n):
    a=list(map(int,input().split()))
    a=a[1:]
    arr.extend(list(set(a)))
arr=list(set(arr))
if arr==b:
    print("YES")
else:
    print("NO")
