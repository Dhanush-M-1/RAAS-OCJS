def check(arr1,arr2,count=0):
    ls=[]
    for i in range(len(arr1)):
        if (arr1[i] in arr2):
            count+=1
            ls.append(arr1[i])
    if(count>0):
        ls.append(count)
    return ls
    
test=int(input())
for _ in range(test):
    n,m=map(int,input().split())
    arr1=list(map(int,input().split()))
    arr2=list(map(int,input().split()))
    count=0
    lis=[]
    if(check(arr1,arr2,count)!=lis):
        print("YES")
        lis+=(check(arr1,arr2,count))
        lis=lis[::-1]
        if(lis[0]>1):
            lis[0]=1
            lis[1]=lis[-2]
            del lis[2::]
        for i in range(len(lis)):
            print(lis[i],end=" ")
        print()
    else:
        print("NO")
    
