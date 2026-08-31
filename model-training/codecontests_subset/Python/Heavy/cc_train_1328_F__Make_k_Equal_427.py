def amount_divide():
    amount_dividers = [[] for _ in range(2 * 10 ** 5 + 1)]
    for i in range(n):
        num = arr[i]
        j = 0
        while num > 0:
            amount_dividers[num].append(j)
            num //= 2
            j += 1
        amount_dividers[0].append(j)

    ans = 10 ** 15
    for list1 in amount_dividers:
        if len(list1) >= k:
            ans = min(ans, sum(sorted(list1)[:k]))
    return ans


n, k = map(int, input().split())
arr = list(map(int, input().split()))
print(amount_divide())
