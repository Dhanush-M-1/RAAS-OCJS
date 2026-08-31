def sol():
    n = int(input())
    arr = list(map(int, input().split(" ")))
    max_a = arr[-1]
    min_a = min(arr[0], arr[1])
    for x in arr:
        max_a = max(max_a, x)
        min_a = min(min_a, x)
    pot = 0

    for x in arr:
        pot += max_a - x
    pot -= max_a - min_a

    if pot >= min_a:
        ans = max_a
    else:
        if (min_a-pot) % (n-1) != 0:
            ans = (min_a - pot) // (n-1) + 1 + max_a
        else:
            ans = (min_a - pot) // (n-1) + max_a
    if n < 3:
        ans = max_a
    print(ans)


sol()
