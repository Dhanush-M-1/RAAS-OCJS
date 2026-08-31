def main():
    h, w, k = map(int, input().split())
    grid = ["."*(w+2)]+["."+input()+"." for _ in [0]*h]+["."*(w+2)]
    visit = [[False]*(w+2) for _ in [0]*(h+2)]
    for i in range(h+2):
        for j in range(w+2):
            if grid[i][j] == "S":
                start = (i, j)
                break
    visit[start[0]][start[1]] = True
    q = [start]
    for i in range(k):
        q2 = []
        while q:
            x, y = q.pop()
            if x-1 >= 0:
                if grid[x-1][y] == "." and visit[x-1][y] is False:
                    q2.append((x-1, y))
                    visit[x-1][y] = True
            if x+1 <= h+1:
                if grid[x+1][y] == "." and visit[x+1][y] is False:
                    q2.append((x+1, y))
                    visit[x+1][y] = True
            if y-1 >= 0:
                if grid[x][y-1] == "." and visit[x][y-1] is False:
                    q2.append((x, y-1))
                    visit[x][y-1] = True
            if y+1 <= w+1:
                if grid[x][y+1] == "." and visit[x][y+1] is False:
                    q2.append((x, y+1))
                    visit[x][y+1] = True
        q = q2
    dist = 10**9
    for i in range(h+2):
        for j in range(w+2):
            if visit[i][j]:
                dist = min([dist, i, h+1-i, j, w+1-j])
    print((max(dist-1, 0)-1)//k+2)


main()