from sys import *


def gcd(a, b):
    if(b == 0):
        return a
    return gcd(b, a % b)


def solve(x):
    i = 1
    t = 1
    while(i*i < x):
        if(x % i == 0 and gcd(i, x//i) == 1):
            t = i
        i += 1
    return(t, x//t)
    pass


test = 1
# test = int(input())
for t in range(0, test):
    # brr = [list(map(int,input().split())) for i in range(rows)]              # 2D array row-wise input
    n = int(input())
    # n, x = list(map(int, input().split()))
    # arr = [int(x) for x in input().split()]
    ans = solve(n)
    print(ans[0], ans[1])


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
