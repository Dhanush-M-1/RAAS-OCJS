import sys
def check(l,r,arr):
    #print(l,'l',r,'r',arr)
    c=0
    if l<r:
        #k=arr[r+1]
        for i in range(l,r+1):
            if arr[i]<c:
                return False
            c+=1
        return True
    else:
        for i in range(l,r-1,-1):
            if arr[i]<c:
                return False
            c+=1
        return True
def get(arr):
    l,r=0,len(arr)-1
    n=len(arr)
    while l<=r:
        mid=(l+r)//2
        x,y=check(0,mid,arr),check(n-1,mid,arr)
        #print(mid,'mid',x,'x',y,'y')
        if arr[mid]<mid and arr[mid]<n-mid-1:
            return False
        if x and y:
            return True
        elif x:
            l=mid+1
        elif y:
            r=mid-1
        else:
            return False
    return False
t=int(sys.stdin.readline())
for _ in range(t):
    n=int(sys.stdin.readline())
    arr=list(map(int,sys.stdin.readline().split()))
    if get(arr):
        print("Yes")
    else:
        print("No")
        
