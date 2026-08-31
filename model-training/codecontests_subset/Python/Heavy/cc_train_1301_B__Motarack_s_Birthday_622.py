T = int(input(),10)

for i in range(T):
    n = int(input(),10)
    arr = input()
    arr = arr.split(' ')
    for i in range(len(arr)):
        arr[i] = int(arr[i],10)
    # print(arr)
    j = 1
    mini = float("inf")
    maxi = 0
    if(arr[0] != -1 and arr[1] == -1):
        mini = min(mini,arr[0])
        maxi = max(maxi,arr[0])
    if(arr[n - 1] != -1 and arr[n - 2] == -1):
        mini = min(mini, arr[n - 1])
        maxi = max(maxi, arr[n - 1])
    while j < (n-1):
        if(arr[j] != -1 and (arr[j - 1] == -1 or arr[j + 1] == -1)):
            mini = min(mini, arr[j])
            maxi = max(maxi, arr[j]) 
        j += 1
    if(mini == float("inf")):
        print(0, 69)
        continue
    avg = (maxi + mini)//2
    # print(maxi, mini, avg)
    for i in range(len(arr)):
        if(arr[i] == -1):
            arr[i] = avg
    ans = 0
    # print(arr)
    for i in range(n - 1):
        ans = max(ans, abs(arr[i] - arr[i + 1]))
    print(ans, avg)



