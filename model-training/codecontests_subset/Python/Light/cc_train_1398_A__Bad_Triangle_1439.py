t = int(input())

for i in range(0,t):
    n = int(input())
    arr = input().split(" ")
    if int(arr[0]) + int(arr[1]) <= int(arr[len(arr)-1]):
        print("1 2 "+str(len(arr)))
    else:
        print("-1")