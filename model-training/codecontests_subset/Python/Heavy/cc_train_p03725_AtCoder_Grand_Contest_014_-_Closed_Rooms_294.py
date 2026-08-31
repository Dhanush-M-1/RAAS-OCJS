h, w, k = [ int(v) for v in input().split() ]
field = [ list(input()) for i in range(h) ]
adjust_list = ((0,1),(0,-1),(1,0),(-1,0))
for i in range(h):
    for j in range(w):
        if field[i][j] == "S":
            s = (i,j)

def nearest(y, x):
    return min(y,h-1-y,x,w-1-x) 


def bfs():
    global field, adjust_list, s
    search_list = [s]
    for _ in range(k):
        new_search_list = []
        for i in search_list:
            for j in adjust_list:
                if 0 <= i[0]+j[0] < h and 0 <= i[1]+j[1] < w:
                    if field[i[0]+j[0]][i[1]+j[1]] == ".":
                        field[i[0]+j[0]][i[1]+j[1]] = "S"
                        new_search_list.append((i[0]+j[0],i[1]+j[1]))
        search_list = new_search_list
    return

bfs()
print(1 + ( min([ nearest(i,j) for j in range(w) for i in range(h) if field[i][j] == "S" ]) + k - 1 ) // k)
