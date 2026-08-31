from sys import stdin, stdout
from sys import maxsize
#input = stdin.readline().strip
from functools import cmp_to_key


def solve(books, k):
    alice = []
    bob = []
    both = []
    for book in books:
        if(book[1] == 1 and book[2] == 1):
            both.append(book[0])
        elif(book[1] == 0 and book[2] == 1):
            bob.append(book[0])
        elif(book[1] == 1 and book[2] == 0):
            alice.append(book[0])
    alice.sort(reverse=True)
    bob.sort(reverse=True)
    both.sort(reverse=True)
    no_of_books, time = 0, 0
    while(len(alice) != 0 and len(bob) != 0 and len(both) != 0 and no_of_books < k):
        no_of_books += 1
        if(alice[-1]+bob[-1] < both[-1]):
            time += alice[-1]+bob[-1]
            alice.pop()
            bob.pop()
        else:
            time += both[-1]
            both.pop()
    while(len(both) != 0 and no_of_books < k):
        no_of_books += 1
        time += both[-1]
        both.pop()
    while(len(alice) != 0 and len(bob) != 0 and no_of_books < k):
        no_of_books += 1
        time += alice[-1]+bob[-1]
        alice.pop()
        bob.pop()
    if(no_of_books == k):
        return time
    else:
        return -1


test = 1
# test = int(input())
for t in range(0, test):
    # brr = [list(map(int,input().split())) for i in range(rows)]              # 2D array row-wise input
    # n = int(input())
    # s = list(input())                                                           # String Input, converted to mutable list.
    n, k = list(map(int, input().split()))
    # arr = [int(x) for x in input().split()]
    b = [tuple(map(int, input().split())) for i in range(n)]
    ans = solve(b, k)
    print(ans)


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
