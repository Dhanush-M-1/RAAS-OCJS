f = [list(input()) for _ in range(4)]

directions = [
    (-1, -1),
    (-1, 0),
    (-1, 1),
    (0, -1),
]

def rev(d):
    return (-d[0], -d[1])

def inside(x, y):
    return x >= 0 and x < 4 and y >= 0 and y < 4

def how_many(x, y, d):
    s = 0
    nx, ny = x + d[0], y + d[1]
    while inside(nx, ny) and f[ny][nx] == "x":
        s += 1
        nx, ny = nx + d[0], ny + d[1]
    return s

def win(x, y):
    if f[y][x] != ".":
        return False
    for d in directions:
        if how_many(x, y, d) + how_many(x, y, rev(d)) >= 2:
            return True
    return False

            
def check():
    for y in range(4):
        for x in range(4):
            if win(x, y):
                print("YES")
                return
    print("NO")

check()
