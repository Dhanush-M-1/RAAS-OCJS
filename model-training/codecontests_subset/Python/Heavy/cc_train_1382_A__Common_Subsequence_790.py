for _ in range(int(input())):
    n,m=map(int,input().split(" "))
    arr1=list(map(int,input().split(" ")))
    arr2=list(map(int,input().split(" ")))
    arr1.sort()
    arr2.sort()
    ans=0;
    flag=0;
    for i in range(n):
        for j in range(m):
            if arr1[i]==arr2[j]:
                  ans=arr1[i]
                  flag=1;
                  break
        if flag==1:
            break
    if flag==1:
        print("YES")
        print("1",ans)
    else:
        print("NO")
                
