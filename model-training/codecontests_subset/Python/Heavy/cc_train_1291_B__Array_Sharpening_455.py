t = int(input())
for i in range(t):
    n = int(input())
    a = [int(v) for v in input().split()]
    # ~ print(a)
    lower_limit = 0
    for j in range(len(a)):
        if a[j] >= j:
            lower_limit += 1
        else:
            break
    upper_limit = len(a)
    for j in range(len(a) - 1, -1, -1):
        if a[j] >= len(a) - 1 - j:
            upper_limit -= 1
        else:
            break
    # ~ print(lower_limit, upper_limit, upper_limit < lower_limit)
    if upper_limit < lower_limit:
        print("Yes")
    else:
        print("No")
