import sys
input=sys.stdin.readline
def chec(arr,brr,mod):
    if(brr[0]>=arr[0]):
        add=brr[0]-arr[0]
    else:
        add=brr[0]+mod-arr[0]
    #print(add)
    for i in range(len(arr)):
        if((arr[i]+add)%mod!=brr[i]):
            return -1
    return add
n,mod=map(int,input().split())
arr=list(map(int,input().split()))
brr=list(map(int,input().split()))
arr.sort()
brr.sort()
flag=chec(arr,brr,mod)
while(flag==-1):
    arr=[arr[n-1]]+arr[0:n-1]
    flag=chec(arr,brr,mod)
    #print(arr,flag)
print(flag)
    
