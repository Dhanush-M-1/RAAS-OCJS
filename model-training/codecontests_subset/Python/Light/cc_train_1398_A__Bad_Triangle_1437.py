n = int(input())

for i in range(n):
    num_arr = int(input())
    arr = input().split(" ")
    
    if (len(arr) < 3):
        print("-1")
        continue

    if (int(arr[0]) + int(arr[1]) <= int(arr[-1])):
        print("1 2 " + str(len(arr)))
    else:
        print("-1")