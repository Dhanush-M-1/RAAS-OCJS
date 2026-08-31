def binary(i,l,h,arr2):
    mid=l+(h-l)//2
    if arr2[mid]==i:
        return True
    elif l>h:
        return False
    else:
        if arr2[mid]>i:
            return binary(i,l,mid-1,arr2)
        else:
            return binary(i,mid+1,h,arr2)
    
for i in range(int(input())):
    n,m=map(int,input().split())
    arr1=list(map(int,input().split()))
    arr2=list(map(int,input().split()))
    arr1.sort()
    arr2.sort()
    for i in arr1:
        if binary(i,0,m-1,arr2):
            print("YES")
            print(1,i)
            break
    else:
        print("NO")
        