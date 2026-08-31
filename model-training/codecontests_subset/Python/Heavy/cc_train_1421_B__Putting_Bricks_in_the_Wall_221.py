from collections import defaultdict
T = int(input())
ans_c = [0] * T
ans_ls = [0] * T

for t in range(T):
    N = int(input())
    grid = [list(input()) for i in range(N)]
    d = defaultdict(int)
    ls = []
    for y,x in [[0,1],[1,0],[N-1,N-2],[N-2,N-1]]:
        d[grid[y][x]] += 1

    same_on_left = True
    if grid[0][1] != grid[1][0]:
        same_on_left = False

    same_on_right = True
    if grid[-1][-2] != grid[-2][-1]:
        same_on_right = False
    if len(d) == 1:
        ans_c[t] = 2
        ans_ls[t] = [[1,2],[2,1]]
        continue
    # 二種類
    # まず、0と1が2ずつの時
    if d['0'] == d['1']:
        if same_on_left and same_on_right:
            ans_c[t] = 0
        else:
            ans_c[t] = 2
            for y,x in [[0,1],[1,0]]:
                if grid[y][x] == '0':
                    ls.append([y+1,x+1])
            for y,x in [[N-1,N-2],[N-2,N-1]]:
                if grid[y][x] == '1':
                    ls.append([y+1,x+1])
    # 3と1の時
    else:
        ans_c[t] = 1
        if same_on_left:
            right = str(int(grid[0][1])^1)
            for y,x in [[N-1,N-2],[N-2,N-1]]:
                if grid[y][x] != right:
                    ls.append([y+1,x+1])
        else:
            left = str(int(grid[N-1][N-2])^1)
            for y,x in [[0,1],[1,0]]:
                if grid[y][x] != left:
                    ls.append([y+1,x+1])
    ans_ls[t] = ls

#print("ans_ls",ans_ls)

for t in range(T):
    print(ans_c[t])
    for ans in ans_ls[t]:
        print(*ans)