arr = [int(x) for x in input().split()]
n = arr[0]
while arr[0] >= arr[1]:
    n = n + int(arr[0]/arr[1])
    arr[0] = arr[0]%arr[1] + int(arr[0]/arr[1])  
print(n)