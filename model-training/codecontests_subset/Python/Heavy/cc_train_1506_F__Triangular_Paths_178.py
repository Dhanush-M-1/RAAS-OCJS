for _ in range(int(input())):
    n = int(input())
    *rows, = map(int, input().split())
    *cols, = map(int, input().split())
    points = sorted(range(n), key=lambda i: rows[i])
    prev_row = 0
    prev_col = 0
    ans = 0
    for point in points:
        prev_diag = prev_row - prev_col
        row = rows[point] - 1
        col = cols[point] - 1
        cur_diag = row - col
        if cur_diag == prev_diag and (cur_diag & 1) == 0:
            ans += row - prev_row
        if (prev_diag & 1) == 0:
            prev_diag += 1
        ans += (cur_diag - prev_diag + 1) // 2
        prev_row, prev_col = row, col
    print(ans)




    


