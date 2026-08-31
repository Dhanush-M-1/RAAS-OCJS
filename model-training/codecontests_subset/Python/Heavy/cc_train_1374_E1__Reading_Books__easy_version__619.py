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

