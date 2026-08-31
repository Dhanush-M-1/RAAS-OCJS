import sys
import math

#to read string
get_string = lambda: sys.stdin.readline().strip()
#to read list of integers
get_int_list = lambda: list( map(int,sys.stdin.readline().strip().split()) )
#to read integers
get_int = lambda: int(sys.stdin.readline().strip())

#--------------------------------WhiteHat010--------------------------------------#
for _ in range(get_int()):
    n = get_int()
    matrix = []
    for i in range(n):
        matrix.append( get_int_list() )
    a = matrix[0][0]
    b = matrix[0][1]
    flag = True
    for i in range(n):
        if matrix[i][0] < a or matrix[i][1] < b:
            flag = False
            break
        if matrix[i][0]-a < matrix[i][1]-b:
            flag = False 
            break
        if matrix[i][0] < matrix[i][1]:
            flag = False
            break
        a = matrix[i][0]
        b = matrix[i][1]
    if flag:
        print("YES")
    else:
        print("NO")