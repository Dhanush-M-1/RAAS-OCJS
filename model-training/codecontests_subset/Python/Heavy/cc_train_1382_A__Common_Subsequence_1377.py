def binarySearch (arr, l, r, x): 
    if r >= l: 
        mid = l + (r - l) // 2
        if arr[mid] == x: 
            return True 
        elif arr[mid] > x: 
            return binarySearch(arr, l, mid-1, x) 
        else: 
            return binarySearch(arr, mid + 1, r, x) 
    else:
        return False
a=int(input())
for i in range(a):
    a1=list(map(int,input().split()))
    ar1=list(map(int,input().split()))
    ar2=list(map(int,input().split()))
    ar1.sort()
    ar2.sort()
    num=0
    flag=0
    for i in ar1:
        if(binarySearch(ar2,0,len(ar2)-1,i)==True):
            flag=1
            num=i
            break
    if(flag==1):
        print("YES")
        print("1",num)
    else:
        print("NO")