from sys import stdin, stdout
from sys import maxsize
input = stdin.readline
# def print(n):
#    stdout.write(str(n)+'\n')


def solve():
    pass


test = 1
test = int(input().strip())
for t in range(0, test):
    # n = int(input().strip())
    # s = list(input().strip())                                                        # String Input, converted to mutable list.
    n, k = list(map(int, input().strip().split()))
    a = [int(x) for x in input().strip().split()]
    b = [int(x) for x in input().strip().split()]
    a = set(a)
    b = set(b)
    x = a.intersection(b)
    if(len(x) == 0):
        print('NO')
    else:
        print('YES')
        x = list(x)
        print(1, x[0])
    # brr = [list(map(int,input().strip().split())) for i in range(rows)]              # 2D array row-wise input
    ans = solve()


'''
rows, cols = (5, 5)
arr = [[0]*cols for j in range(rows)]                                         # 2D array initialization
rev_str=s[::-1]                                                               # To reverse given string
b=input().strip().split()                                                     # list created by spliting about spaces
brr = [[int(b[cols*i+j]) for j in range(cols)] for i in range(rows)]          # 2D array Linear Input
rows,cols=len(brr),len(brr[0])                                                # no of rows/cols for 2D array
arr.sort(key = lambda x : x[1])                                               # sort list of tuples by 2nd element, Default priority - 1st Element then 2nd Element
s=set()                                                                       # empty set
a=maxsize                                                                     # initializing infinity
b=-maxsize                                                                    # initializing -infinity
mapped=list(map(function,input))                                              # to apply function to list element-wise
try:                                                                          # Error handling
    #code 1
except:                                                                       # ex. to stop at EOF
    #code 2 , if error occurs
'''
