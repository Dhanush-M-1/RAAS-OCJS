INF = 1000000000

def bfs(sta,fin):
    from collections import deque
    visit = deque()

    dx = [0,-1,-1,-1,0,1,1,1]
    dy = [1,1,0,-1,-1,-1,0,1]

    visit.append(sta)
    while len(visit) > 0:
        vertex = visit.popleft()

        for i in range(8):
            nx = vertex[0] + dx[i]
            ny = vertex[1] + dy[i]

            if (1 <= nx <= INF) and (1 <= ny <= INF) and ((nx,ny) in board) and (board[(nx,ny)] == -1):
                visit.append((nx,ny))
                board[(nx, ny)] = 0
                dist[(nx,ny)] = dist[vertex] + 1

                if (nx,ny) == fin:
                    print(dist[(nx,ny)],end='')
                    return True

    return False


if __name__ == '__main__':
    board, dist = dict(), dict()

    x0, y0, x1, y1 = map(int, input().split())
    sta = (x0, y0)
    fin = (x1, y1)
    dist[sta] = 0

    n = int(input())
    for _ in range(n):
        line = input()
        r, a, b = map(int, line.split())
        for i in range(a,b+1):
            board[(r,i)] = -1
            dist[(r, i)] = 0

    if not bfs(sta,fin):
        print(-1,end='')