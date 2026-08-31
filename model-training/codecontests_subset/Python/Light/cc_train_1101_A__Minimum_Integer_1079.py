j=int(input())
for i in range(j):
    arr=[int(x) for x in input().split()]
    if arr[2]<arr[0] or arr[2]>arr[1]:
        print(arr[2])
    elif arr[2]>=arr[0] and arr[2]<=arr[1]:
        temp=arr[1]-arr[2]
        if ((temp//arr[2])+2)*arr[2]!=arr[1]:
            print(arr[2]*((temp//arr[2])+2))
        else:
            print(arr[2]*((temp//arr[2])+3))