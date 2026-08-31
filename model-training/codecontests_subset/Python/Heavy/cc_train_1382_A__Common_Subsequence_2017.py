for _ in range(int(input())):
    length = list(map(int,input().split()))
    a_length = length[0]
    b_length = length[1]
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    breaking = 0
    ans = -1
    for count_a in range(a_length):
        for count_b in range(b_length):
            if a[count_a] == b[count_b]:
                ans = a[count_a]
                breaking = 1
                break
        if breaking:
            break
    if ans == -1:
        print('NO')
    else:
        print('YES')
        print(1,ans)
