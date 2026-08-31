def dfs(mat, r, c, visited, limit):
    dfsStack = [(r,c)]
    while dfsStack and limit > 0:
        i, j = dfsStack.pop()
        if 0 <= i < len(mat) and 0 <= j < len(mat[i]) and mat[i][j] == "." and not visited[i][j]:
            mat[i][j] = "C"
            visited[i][j] = True
            limit -= 1
            dfsStack.append((i + 1, j))
            dfsStack.append((i - 1, j))
            dfsStack.append((i, j - 1))
            dfsStack.append((i, j + 1))
            
# main method
height, width, walls = map(int, input().split())
empty = 0
mat = []
visited = []
i = -1
j = -1
for r in range(height):
    line = input()
    if i == j == -1 and line.find(".") > -1:
        i = r
        j = line.index(".")
    mat.append(list(line))
    visited.append([False] * len(line))
    empty += line.count(".")
emptyLeft = empty - walls
# we want to get an {emptyLeft} size connected component
# then mark all the other empty cells as walls 
dfs(mat, i, j, visited, emptyLeft)
 
# mark connected component as empty first
# other empty cells changed to walls
# print mat
for i in range(height):
    line = "".join(mat[i])
    print(line.replace(".", "X").replace("C", "."))