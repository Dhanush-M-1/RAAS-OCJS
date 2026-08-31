
arr = [int(n) for n in input().split("+")]
ans = [0 for n in range(0, len(arr))]
if len(arr) == 0:
    print()
if len(arr) == 1:
    print(arr[0])
else:
    j = 0
    for i in range(len(arr)):
        if arr[i] == 1:
            ans[j] = arr[i]
            j += 1
    for i in range(len(arr)):
        if arr[i] == 2:
            ans[j] = arr[i]
            j += 1
    for i in range(len(arr)):
        if arr[i] == 3:
            ans[j] = arr[i]
            j += 1
    ans_str = ""
    for i in range(len(arr)-1):
        ans_str += str(ans[i])+"+"
    ans_str += str(ans[len(ans)-1])

    print(ans_str)
