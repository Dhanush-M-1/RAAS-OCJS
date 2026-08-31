import sys
from copy import deepcopy 

def passer(n,m):
    for i in range(n):
        for j in range(m):
            yield i,j

def is_won(data):
    mat = [ [ (1 if j == 'x' else 0) for j in i] for i in data ]
    tmat = deepcopy(mat)
    for i,j in passer(4,4):
        if j != 0 and tmat[i][j] == 1 and tmat[i][j-1] != 0:
            tmat[i][j] += tmat[i][j-1]
        if tmat[i][j] == 3:
            return True
    #print(tmat)

    tmat = deepcopy(mat)
    for i,j in passer(4,4):
        if i != 0 and tmat[i][j] == 1 and tmat[i-1][j] != 0:
            tmat[i][j] += tmat[i-1][j]
        if tmat[i][j] == 3:
            return True
    #print(tmat)

    tmat = deepcopy(mat)
    for i,j in passer(4,4):
        if i != 0 and j != 0 and tmat[i][j] == 1 and tmat[i-1][j-1] != 0:
            tmat[i][j] += tmat[i-1][j-1]
        if tmat[i][j] == 3:
            return True
    #print(tmat)

    tmat = deepcopy(mat)
    for i,j in passer(4,4):
        if i != 0 and j != 3 and tmat[i][j] == 1 and tmat[i-1][j+1] != 0:
            tmat[i][j] += tmat[i-1][j+1]
        if tmat[i][j] == 3:
            return True
    #print(tmat)

        
#sys.stdin = open('input.txt','r')
input_data = []

for i in range(4):
    input_data.append( input().rstrip() )

for i,j in passer(4,4):
    if is_won(input_data):
        print('YES')
        break
    
    if input_data[i][j] == '.':
        copy_data = input_data.copy()
        copy_data[i] = copy_data[i][:j] + 'x' + copy_data[i][j+1:]
        if is_won(copy_data):
            print('YES')
            break
else:
    print('NO')
