import sys, collections, itertools, copy

def bfs(num):
    check = [[False] * n for _ in range(n)]
    q = collections.deque()
    q.append((0,0))
    check[0][0] = True
    while q:
        x, y = q.popleft()
        if x == n - 1 and y == n - 1:
            return True
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if temp[nx][ny] != num:
                    if not check[nx][ny]:
                        check[nx][ny] = True
                        q.append((nx, ny))
    return False

tc = int(sys.stdin.readline())
dx = [0,1,0,-1]
dy = [1,0,-1,0]
for _ in range(tc):
    n = int(sys.stdin.readline())
    arr = [list(sys.stdin.readline().rstrip()) for _ in range(n)]
    find = False
    for i in itertools.combinations([(0,1), (1,0), (n - 2, n - 1), (n - 1, n - 2)], 2):
        temp = copy.deepcopy(arr)
        for j in i:
            if temp[j[0]][j[1]] == '1':
                temp[j[0]][j[1]] = '0'
            else:
                temp[j[0]][j[1]] = '1'
        if not bfs('0') and not bfs('1'):
            find = True
            print(2)
            for j in i:
                print(j[0] + 1, j[1] + 1)
            break
    if not find:
        for i in [(0,1), (1,0), (n - 2, n - 1), (n - 1, n - 2)]:
            temp = copy.deepcopy(arr)
            if temp[i[0]][i[1]] == '1':
                temp[i[0]][i[1]] = '0'
            else:
                temp[i[0]][i[1]] = '1'
            if not bfs('0') and not bfs('1'):
                find = True
                print(1)
                print(i[0] + 1, i[1] + 1)
                break
    if not find:
        print(0)

