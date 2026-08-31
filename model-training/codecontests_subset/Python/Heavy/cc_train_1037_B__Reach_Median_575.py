from bisect import bisect_right


N, S = [int(x) for x in input().split()]
arr = [int(x) for x in input().split()]
arr.sort()
center_index = N // 2
S_index = bisect_right(arr, S) - 1
moves = 0

if N == 1:
    moves = abs(arr[0] - S)
else:
    if S_index > center_index:
        for i in range(center_index, S_index + 1):
            moves += S - arr[i]
    elif S_index < center_index:
        for i in range(S_index + 1, center_index + 1):
            moves += arr[i] - S
    else:
        moves = abs(S - arr[center_index])

print(moves)
