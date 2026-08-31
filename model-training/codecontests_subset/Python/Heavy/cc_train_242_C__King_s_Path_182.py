import collections
def kingpath():
    def adds(x, y, c):
        s = (x, y)
        if s in sgs and s not in his:
            todo.append([x, y, c + 1])
            his.add(s)
 
    startx, starty, endx, endy = map(int, input().split())  # need to minus one
    seg = int(input())
    sgs = set()
    for i in range(seg):
        row, s, e = map(int, input().split())
        for i1 in range(s, e + 1):
            sgs.add((row, i1))
    todo = collections.deque([[startx, starty, 0]])
    his = set()
    while todo:
        x, y, step = todo.popleft()
        if x == endx and y == endy:
            return step
        adds(x - 1, y, step)
        adds(x + 1, y, step)
        adds(x, y - 1, step)
        adds(x, y + 1, step)
        adds(x - 1, y - 1, step)
        adds(x + 1, y + 1, step)
        adds(x - 1, y + 1, step)
        adds(x + 1, y - 1, step)
    return -1
 
 
print(kingpath())