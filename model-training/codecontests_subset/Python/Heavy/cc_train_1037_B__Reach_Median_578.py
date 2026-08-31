def findmedium(s,n):
    global arr
    mid=int(n/2)
    step=0
    if(arr[mid]>s):
        step+=arr[mid]-s
        arr[mid]=s
        for i in range(mid-1,-1,-1):
            if(arr[i]>s):
                step+=arr[i]-s
                arr[i]=s
            else:
                break
    elif(arr[mid]<s):
        step+=s-arr[mid]
        arr[mid]=s
        for i in range(mid+1,n):
            if(arr[i]<s):
                step+=s-arr[i]
                arr[i]=s
            else:
                break
    print(step)         
arr=[]
n,s=map(int, input().lstrip().split())
arr=list(map(int, input().lstrip().split()))
arr.sort()
findmedium(s,n)
