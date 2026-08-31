(n ,s)= [int(s) for s in input().split(" ")]

arr = [int(s) for s in input().split(" ")]
arr_plus = []
arr_minus = []
found_zero = False
min_plus = 10**9+1
max_minus = -10**9-1

for i in range(n):
    arr[i] -= s
    if arr[i] < 0:
        arr_minus.append(arr[i])
        max_minus = max(max_minus, arr[i])
    elif arr[i] > 0:
        arr_plus.append(arr[i])
        min_plus = min(min_plus, arr[i])
    else:
        found_zero = True
temp = 0
# print(arr_minus)
# print(arr_plus)
# print(max_minus)
# print(min_plus)

if len(arr_plus) > n//2:
    arr_plus.sort()
    delta = len(arr_plus) - n//2
    # print(delta)
    temp= sum(arr_plus[:delta])
    # if not found_zero:
    #     temp+= arr_plus[delta]
elif len(arr_minus) > n//2:
    arr_minus.sort()
    delta = len(arr_minus) - n//2
    # print(delta)
    temp = abs(sum(arr_minus[-delta:]))
    # if not found_zero:
    #     temp+=abs(arr_minus[-delta-1])
print(temp)

