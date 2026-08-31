


for _ in range(int(input())):
    input()
    arr=[int(x) for x in input().split()]
    print(*([1,2,len(arr)],[-1])[arr[0]+arr[1]>arr[-1]])