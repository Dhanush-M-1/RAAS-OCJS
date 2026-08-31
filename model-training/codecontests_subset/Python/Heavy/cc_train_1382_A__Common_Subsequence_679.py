t=int(input())
for i in range(t):
    n,k=map(int,input().split())
    arr=list(map(int,input().split()))
    arr2=list(map(int,input().split()))
    var=-1
    if(n>k):
        for j in range(n):
            if(arr[j] in arr2):
                var=arr[j]
                break
        if(var!=-1):
            print("YES")
            print(1,var)
        else:
            print("NO")
    else:
        for j in range(k):
            if(arr2[j] in arr):
                var=arr2[j]
                break
        if(var!=-1):
            print("YES")
            print(1,var)
        else:
            print("NO")