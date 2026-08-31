n,m=map(int,input().split())
arr1=[int(i) for i in range(1,m+1)]
l=[]
for i in range(n):
    arr=[int(z) for z in input().split()]
    for x in arr[1:]:
        if x not in l:
            l.append(x)
l.sort()
if arr1==l:
    print("YES")
else:
    print("NO")

    
