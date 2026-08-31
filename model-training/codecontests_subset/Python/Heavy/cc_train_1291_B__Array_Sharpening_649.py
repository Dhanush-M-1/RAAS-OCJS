for case in range(int(input())):
    n = int(input())
    digits = [int(x) for x in input().split()]
    mini = 9999999999999
    mini_index = 0
    for i in range(n):
        if digits[i] < mini:
            mini_index = i
            mini = digits[i]

    lefts = []
    rights = []
    for i in range(n):
        lefts.append(digits[i] >= i)
    for i in range(n):
        rights.append(digits[i] >= n - i -1)

    # print(lefts)
    # print(rights)

    cons_left = -1
    x = 0
    while x < n and lefts[x]:
        cons_left += 1
        x += 1
    cons_right = n
    x = n-1
    while x >= 0 and rights[x]:
        cons_right -= 1
        x -= 1
    # print(cons_left, cons_right)
    if cons_left >= cons_right:
        print("YES")
    else:
        print("NO")