# @author 

import sys

class E1ReadingBooksEasyVersion:
    def solve(self, tc=0):
        n, k = [int(_) for _ in input().split()]
        books = []
        for i in range(n):
            books.append([int(_) for _ in input().split()])
        a = []
        b = []
        both = []
        for i in range(n):
            book = books[i]
            if book[1] and book[2]:
                both.append(book[0])
            elif book[1]:
                a.append(book[0])
            elif book[2]:
                b.append(book[0])
        a.sort()
        b.sort()
        both.sort()
        # print(a)
        # print(b)
        # print(both)

        prea = [0] * (len(a) + 1)
        for i in range(1, len(a) + 1):
            prea[i] = prea[i - 1] + a[i - 1]

        preb = [0] * (len(b) + 1)
        for i in range(1, len(b) + 1):
            preb[i] = preb[i - 1] + b[i - 1]

        preboth = [0] * (len(both) + 1)
        for i in range(1, len(both) + 1):
            preboth[i] = preboth[i - 1] + both[i - 1]


        ans = float('inf')
        for i in range(len(both) + 1):
            if i > k:
                break
            if len(a) >= k - i and len(b) >= k - i:
                ans = min(ans, preboth[i] + prea[k - i] + preb[k - i])

        print(ans if ans != float('inf') else -1)

        # na, nb, nboth
        # na + nboth = k
        # nb + nboth = k

solver = E1ReadingBooksEasyVersion()
input = sys.stdin.readline

solver.solve()
