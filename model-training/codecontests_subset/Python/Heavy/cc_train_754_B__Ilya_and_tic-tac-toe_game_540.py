dx = [1,1,1,0,0,-1,-1,-1]
dy = [1,0,-1,1,-1,1,0,-1]
ddx = [2,2,2,0,0,-2,-2,-2]
ddy = [2,0,-2,2,-2,2,0,-2]
mapn = []

def check(hex, i, j):
    """
    :type hex: str
    :type i: int
    :type j: int
    :rtype: bool
    """
    for k in range(8):
        if i+dx[k] >= 0 and i+dx[k] < 4 and j+dy[k] >= 0 and j+dy[k] < 4:
            if mapn[i+dx[k]][j+dy[k]] == hex:
                if i+2*dx[k] >= 0 and i+2*dx[k] < 4 and j+2*dy[k] >= 0 and j+2*dy[k] < 4:
                    if mapn[i+2*dx[k]][j+2*dy[k]] == '.':
                        return True
                    else:
                        continue
            else:
                continue
    for k in range(8):
        if i+ddx[k] >= 0 and i+ddx[k] < 4 and j+ddy[k] >= 0 and j+ddy[k] < 4:
            if mapn[i+ddx[k]][j+ddy[k]] == hex:
                if mapn[i+dx[k]][j+dy[k]] == '.':
                    return True
                else:
                    continue
            else:
                continue
    return False


def main():
    for i in range(4):
        mapn.append(input())
    num_x = 0
    num_o = 0
    for i in range(4):
        for j in range(4):
            if mapn[i][j] == 'x':
                num_x = num_x + 1
            elif mapn[i][j] == 'o':
                num_o = num_o + 1
            else:
                continue
    flag = 0
    if num_x <= num_o:
        # x
        for i in range(4):
            for j in range(4):
                if mapn[i][j] == 'x':
                    if(check('x', i, j)):
                        flag = 1
    else:
        # o
        for i in range(4):
            for j in range(4):
                if mapn[i][j] == 'o':
                    if(check('o', i, j)):
                        flag = 1
    if flag:
        print("YES")
    else:
        print("NO")
    
main()  