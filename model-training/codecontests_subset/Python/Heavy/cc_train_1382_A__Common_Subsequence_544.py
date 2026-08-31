# cook your dish here
for _ in range(int(input())):
    n , m = map(int,input().split())
    arr1 = list(map(int,input().split()))
    arr2 = list(map(int,input().split()))
    h1={}
    h2={}
    ans=-1
    for i in range(len(arr1)):
        if arr1[i] not in h1:
            h1[arr1[i]]=1
    for i in range(len(arr2)):
        if arr2[i] not in h2:
            h2[arr2[i]]=1
    for i in range(len(arr1)):
        if arr1[i] in h2:
            ans=arr1[i]
            break
    if ans>0:
        print("YES")
        print("1",ans)
    else:
        print("NO")
    
    