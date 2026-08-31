import os

import sys

debug = True

if debug and os.path.exists("input.in"):
    input = open("input.in", "r").readline
else:
    debug = False
    input = sys.stdin.readline


def inp():
    return (int(input()))


def inlt():
    return (list(map(int, input().split())))


def insr():
    s = input()
    return s[:len(s) - 1]  # Remove line char from end


def invr():
    return (map(int, input().split()))


test_count = 1
if debug:
    test_count = inp()

for t in range(test_count):
    if debug:
        print("Test Case #", t + 1)
    # Start code here
    n, k = invr()
    books = [None] * n
    alice = []
    bob = []
    both = []
    for i in range(n):
        books[i] = inlt()

    books.sort()

    ans = 0
    done = False
    for book in books:
        if book[1] == 1 and book[2] == 1:
            both.append(book[0])
        elif book[1] == 1:
            alice.append(book[0])
        elif book[2] == 1:
            bob.append(book[0])
    c = 0
    cnt = 0
    # print(alice, bob, both)
    while k > 0 and cnt < min(len(alice), len(bob)):
        if c < len(both) and alice[cnt] + bob[cnt] > both[c]:
            ans += both[c]
            c += 1
        else:
            ans += alice[cnt] + bob[cnt]
            cnt += 1
        k -= 1

    for i in range(k):
        if c < len(both):
            ans += both[c]
            k -= 1
            c += 1
    if k != 0:
        print(-1)
    else:
        print(ans)
