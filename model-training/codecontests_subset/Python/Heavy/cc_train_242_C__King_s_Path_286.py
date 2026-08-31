from sys import stdin, stdout
from collections import deque

x0, y0, x1, y1 = map(int, stdin.readline().split())
n = int(stdin.readline())

allowed = {}

for _ in range(n):
    r, a, b = map(int, stdin.readline().split())
    
    if r in allowed:
        allowed[r].append([a, b])
    else:
        allowed[r] = [[a, b]]
        
# merge all intervals

for r in allowed:
    old = allowed[r]
    old.sort(key=lambda x: x[0])
    
    compressed = [old[0]]
    for i in range(1, len(old)):
        if old[i][0] <= compressed[-1][1]:
            compressed[-1][1] = max(old[i][1], compressed[-1][1])
        else:
            compressed.append(old[i])
        
    allowed[r] = compressed
            
#print(allowed)


def check_valid(r, box):
    if r <= 0 or box <= 0 or r > 1e9 or box > 1e9:
        return False
    if r not in allowed:
        return False
    for a, b in allowed[r]:
        if a <= box <= b:
            return True
    return False

def bfs(start, target):
    q = deque()
    # start is a tuple, target is a tuple
    q.append((start, 0))
    
    visited = set()
    
    while q:
        square, moves = q.popleft()
        
        dr = [-1, -1, 0, 1, 1, 1, 0, -1]
        dx = [0, 1, 1, 1, 0, -1, -1, -1]
        
        for i in range(8):
            new_square = (square[0]+dr[i],
                           square[1]+dx[i])
            
            if check_valid(*new_square) and \
               new_square not in visited:
                if new_square == target:
                    return moves + 1
                q.append((new_square, moves + 1))
                visited.add(new_square)
                
    return -1
                    
print(bfs((x0, y0), (x1, y1)))        
        
        
        
        
        
