def get_k(n, arr):
    mini, maxi = float('inf'), -float('inf')
    if all([item == -1 for item  in arr]):
        return 0, 0
    for i, item in enumerate(arr):
        if item == -1:
            if i-1 >= 0 and arr[i-1] != -1:
                mini = min(arr[i - 1], mini)
                maxi = max(arr[i - 1], maxi)
            if i+1 < n and arr[i+1] != -1:
                mini = min(arr[i + 1], mini)
                maxi = max(arr[i + 1], maxi)
    k = (mini+maxi)//2

    m = 0
    arr = [item if item != -1 else k for item in arr]
    i = 1
    while i < n:
        m = max(abs(arr[i] - arr[i-1]), m)
        i += 1
    return m, k


if __name__ == '__main__':
    T = int(input().strip())
    for t in range(T):
        n = int(input().strip())
        arr = list(map(int, input().strip().split()))
        print(*get_k(n, arr))


'''
1 11
5 37
3 6
0 0
0 0
1 2
3 4

=====
Used: 108 ms, 4 KB'''