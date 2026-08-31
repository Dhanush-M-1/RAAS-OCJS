def deg(arr):
    ma=arr[-1]
    if (arr[0]+arr[1])>ma:
        return -1
    else:
        return (1,2,len(arr))

t=int(input())
for i in range(t):
    n=int(input())
    arr1=[int(k) for k in input().split()] 
    t=deg(arr1)
    if t==-1:
        print(-1)
    else:
        print(t[0],t[1],t[2])