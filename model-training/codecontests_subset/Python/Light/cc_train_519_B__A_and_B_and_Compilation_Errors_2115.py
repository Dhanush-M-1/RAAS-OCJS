n=int(input())
arr=list(map(int,input().split()))
arr2=list(map(int,input().split()))
arr3=list(map(int,input().split()))
arr=sorted(arr)
arr2=sorted(arr2)
arr3=sorted(arr3)


for i in range(n):
    if i>len(arr2)-1:
        ans=arr[i]

        break
    elif arr[i]!=arr2[i]:
        ans=arr[i]

        break
for i in range(len(arr2)):
    if i>len(arr3)-1:
        ans2=arr2[i]

        break
    elif arr2[i]!=arr3[i]:
        ans2=arr2[i]
        break
print(ans)
print(ans2)
