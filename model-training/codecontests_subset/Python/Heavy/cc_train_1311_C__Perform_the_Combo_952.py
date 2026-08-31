from bisect import bisect_left
for _ in range(int(input())):
    n, m = map(int, input().split())
    s = input()
    arr = sorted(list(map(int, input().split())))
    ans = [0 for i in range(26)]
    for i in s:
        ans[ord(i) - ord('a')] += 1
    t = n
    val = []

    for i in range(1, max(arr) + 1):
        ind = bisect_left(arr, i)
        val.append(len(arr) - ind)
    for i in range(n - len(val)):
        val.append(0)
    for i in range(len(s)):
        ans[ord(s[i]) - ord('a')] += val[i]
    for i in ans:
        print(i, end=' ')
    print()






