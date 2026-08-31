def binary_search(arr, val):
    l = -1
    r = len(arr)
    while r - l > 1:
        m = (l + r) >> 1
        if arr[m] == val:
            return m + 1
        if arr[m] > val:
            r = m
        if arr[m] < val:
            l = m
    return -1


t = int(input())
answers = []

for ti in range(t):
    n, m = list(map(int, input().split()))
    s = input()
    p = list(map(int, input().split()))

    ans = [0] * 26

    a = [0] * len(s)
    for pi in p:
        a[pi - 1] += 1

    a.reverse()

    non_zero = a[0]
    for i in range(len(a)):
        a[i] += non_zero
        non_zero = a[i]

    a.reverse()

    for i in range(len(s)):
        order = ord(s[i]) - ord('a')
        ans[order] += a[i]

    for c in s:
        order = ord(c) - ord('a')
        ans[order] += 1

    answers.append(ans)

for a in answers:
    print(*a)
