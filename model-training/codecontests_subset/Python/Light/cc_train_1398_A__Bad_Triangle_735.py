for i in range(int(input())):
    n=int(input())
    arr=list(map(int,input().split()))
    flag=0
    for i in range(len(arr)-1):
        for j in range(i+1,len(arr)-1):
            if arr[i]+arr[j]<=arr[len(arr)-1]:
                flag=1
                print(i+1,j+1,len(arr))
                m=len(arr)
                arr.remove(arr[m-1])
                break
        break
    if flag==0:
        print(-1)