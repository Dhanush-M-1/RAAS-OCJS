
for _ in range(int(input())):
    n = input()
    num = list(map(int, input().split()))
    chk = 0
    i = 0
    j = len(num) - 1
    check = False
    while True:
        if i > j:
            check = True
            break
        if i + 1 == j:
            if (num[i] >= chk and num[j] >= chk + 1) or (num[i] >= chk + 1 and num[j] >= chk):
                check = True
            break
        if num[i] >= chk and num[j] >= chk:
            chk += 1
            i += 1
            j -= 1
            continue
        break
    if check:
        print("Yes")
    else:
        print("No")
