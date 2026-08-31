import sys
from copy import deepcopy 

def passer(n,m):
    for i in range(n):
        for j in range(m):
            yield i,j

def is_won(data):
    mat = [ [ (1 if j == 'x' else 0) for j in i] for i in data ]
    d = [ (-1,0) , (0,-1) , (-1,-1) , (-1,1) ]
    
    for dx,dy in d:
        tmat = deepcopy(mat)
        for i,j in passer(4,4):
            if (i+dx >= 0 and i+dx < 4 and j+dy >= 0 and j+dy < 4 and 
                tmat[i][j] == 1 and tmat[i+dx][j+dy] != 0):
                tmat[i][j] += tmat[i+dx][j+dy]
            if tmat[i][j] == 3:
                return True

        
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
