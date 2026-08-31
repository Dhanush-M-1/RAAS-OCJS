t=int(input())
i=0
while i<t:
    n,m=map(int,input().split())
    arr1=list(map(int,input().split()))
    arr2=list(map(int,input().split()))
    if n<=m:
        res=[]
        for x in range(n):
            if arr1[x] in arr2:
                res.append(arr1[x])
                print("YES")
                print(1,res[0])
                break
        if len(res)==0:
            print("NO")
            
    else:
        res=[]
        for x in range(m):
            if arr2[x] in arr1:
                res.append(arr2[x])
                print("YES")
                print(1,res[0])
                break
        if len(res)==0:
            print("NO")
        
        
    i=i+1
