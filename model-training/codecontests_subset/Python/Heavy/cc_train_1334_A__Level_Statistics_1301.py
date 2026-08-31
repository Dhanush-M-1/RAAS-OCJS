for i in range(int(input())):
    ans = ''
    n = int(input())
    for j in range(n):
        a, b = map(int, input().split())
        if j == 0:
            a_prev, b_prev = a, b
            dif = a - b
            if dif < 0:
                ans = 'NO'
        else:
            if a - b < dif or a < a_prev or b < b_prev:
                ans = 'NO'
            else:
                a_prev, b_prev = a, b
                dif = a - b
        if j == n - 1:
            print('YES') if ans == '' else print(ans)
