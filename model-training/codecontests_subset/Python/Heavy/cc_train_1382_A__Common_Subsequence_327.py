def binary_search(arr,l,r,x):
    if l<=r:
        mid=(l+r)//2
        if arr[mid]==x:
            return arr[mid]
        elif arr[mid]<x:
            return binary_search(arr,mid+1,r,x)
        else:
            return binary_search(arr,l,mid-1,x)
    else:
        return -1
for _ in range(int(input())):
    n,m=map(int,input().split())
    flag,k=0,0
    a,b=sorted([int(x) for x in input().split()]),sorted([int(y) for y in input().split()])
    for i in a:
        if binary_search(b,0,len(b)-1,i)!=-1:
            k=i
            flag=1
            break;
        else:
            continue
    if (flag==1):
        print("YES")
        print(1,k)
    else:
        print("NO")