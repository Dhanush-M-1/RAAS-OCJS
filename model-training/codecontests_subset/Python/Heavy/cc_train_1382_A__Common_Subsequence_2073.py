t= int(input())
while t>0:
    m,n=map(int,input().split())
    arr1= list(map(int, input().strip().split()))[:m]
    arr2= list(map(int, input().strip().split()))[:n]
    
    final=["/"]
    index=[-1]
    for i in range(len(arr1)):
        for j in range(len(arr2)):
            if arr1[i]==arr2[j] and j>index[-1]:
                final.append(arr1[i])
                index.append(j)
    final.pop(0)
    if len(final)==0:
        print("NO")
    else:
        print("YES")
        print("1"+" "+str(min(final)))
    

    t-=1