n,k=list(map(int,input().split()))
arr1=[]
arr2=[]
arr3=[]
x=0
y=0
for i in range(n):
    num1=list(map(int,input().split()))
    if num1[1]==1 and num1[2]==1:
        arr3.append(num1[0])
        x+=1
        y+=1
    elif num1[1]==1 and num1[2]==0:
        arr1.append(num1[0])
        x+=1
    elif num1[1]==0 and num1[2]==1:
        arr2.append(num1[0])
        y+=1
if x<k or y<k:
    print(-1)
else:
    arr1.sort()
    arr2.sort()
    a=len(arr1)
    b=len(arr2)
    for i in range(min(a,b)):
        arr3.append(arr1[i]+arr2[i])
    arr3.sort()
    ans=0
    for i in range(k):
        ans+=arr3[i]
    print(ans)
    