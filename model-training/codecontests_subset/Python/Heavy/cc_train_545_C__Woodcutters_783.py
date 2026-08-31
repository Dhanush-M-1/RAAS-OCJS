n = int(input())
cnt = 0
flag = 0
for i in range(n):
    x, h = map(int, input().split())
    if i == 0:
        cnt += 1
        x_prev = x
        flag = 1
    else:
        if flag == 1:
            if x - x_prev > h and i != n - 1:
                cnt += 1
                x_prev = x
            else:
                flag = 0
                x_prev = x
                h_prev = h
        elif flag == 0:
            if x - x_prev > h + h_prev and i != n - 1:  # > or >= ?
                cnt += 2
                flag = 1
                x_prev = x
            elif x - x_prev > h_prev:
                cnt += 1
                x_prev = x
                h_prev = h
            elif x - x_prev > h and i != n - 1:
                cnt += 1
                x_prev = x
                flag = 1
            else:
                x_prev = x
                h_prev = h
    if i == n - 1 and n != 1:
        if flag == 0:
            if x - x_prev > h_prev:
                cnt += 2
            else:
                cnt += 1
        elif flag == 1:
            cnt += 1
print(cnt)
# 3
# 1 2
# 5 10
# 20 2
