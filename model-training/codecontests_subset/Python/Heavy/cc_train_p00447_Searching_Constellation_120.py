board = [[False]*1000001]*1000001
while True:
    m = int(input())
    if m == 0: break
    sx, sy = map(int, input().split())
    star = []
    for i in range(m-1):
        x, y = map(int, input().split())
        star.append((x-sx, y-sy))
    
    
    n = int(input())
    starlist = [tuple(map(int, input().split())) for i in range(n)]
    for i in range(n):
        board[starlist[i][0]][starlist[i][1]] = True
    for i in range(n):
        flag = True
        for j in range(len(star)):
            dx = starlist[i][0] + star[j][0]
            dy = starlist[i][1] + star[j][1]
            if 0 <= dx <= 1000000 and 0 <= dy <= 1000000 and board[dx][dy] == False:
                flag = False
                break
        if flag == True:
            print("{} {}".format(str(starlist[i][0] - sx), str(starlist[i][1] -sy)))
            break
    