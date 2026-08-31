from sys import stdin, stdout
from sys import maxsize
#input = stdin.readline().strip


def solve():
    pass


test = 1
test = int(input())
for t in range(0, test):
    # brr = [list(map(int,input().split())) for i in range(rows)]              # 2D array row-wise input
    n = int(input())
    p2, p3 = 0, 0
    while(n % 2 == 0):
        p2 += 1
        n = n//2
    while(n % 3 == 0):
        p3 += 1
        n = n//3
    if(n != 1):
        print(-1)
    else:
        if(p2 > p3):
            print(-1)
        else:
            print(2*p3-p2)
    # s = list(input())                                                        # String Input, converted to mutable list.
    # n, x = list(map(int, input().split()))
    # arr = [int(x) for x in input().split()]
    ans = solve()


'''
rows, cols = (5, 5)
arr = [[0]*cols for j in range(rows)]                                         # 2D array initialization
b=input().split()                                                             # list created by spliting about spaces
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
