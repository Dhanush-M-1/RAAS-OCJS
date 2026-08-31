from typing import List
from heapq import heappop, heappush

# Dictionary. Still using a heap for prioritization, but this should be faster than previous solution.
def readingBooks_easy(n: int, k: int, books: List[int]) -> int:
    books.sort(key = lambda x: x[0])
    alice = []
    bob = []
    alice_and_bob = []
    for i in range(len(books)):
        if (books[i][1] == 1 and books[i][2] == 0):
            alice.append(books[i][0])
        elif (books[i][1] == 0 and books[i][2] == 1):
            bob.append(books[i][0])
        elif (books[i][1] == 1 and books[i][2] == 1):
            alice_and_bob.append(books[i][0])

    alice_or_bob = []
    for i in range(min(len(alice), len(bob))):
        alice_or_bob.append(alice[i] + bob[i])

    heap = []
    dic = {}
    for i in range(len(alice_and_bob)):
        if (alice_and_bob[i] in dic):
            dic[alice_and_bob[i]] += 1
        else:
            dic[alice_and_bob[i]] = 1
            heappush(heap, alice_and_bob[i])

    for i in range(len(alice_or_bob)):
        if (alice_or_bob[i] in dic):
            dic[alice_or_bob[i]] += 1
        else:
            dic[alice_or_bob[i]] = 1
            heappush(heap, alice_or_bob[i])

    ans = 0
    while (k > 0):
        if (heap):
            popped = heappop(heap)
            read = min(dic[popped], k)
            cost = read*popped
            k -= read
            dic[popped] -= read
            if (dic[popped] <= 0):
                del(dic[popped])
            else:
                heappush(heap, popped)
            ans += cost

        else:
            return -1
    return ans

# Heap (worked like a charm ;) )
# def readingBooks_easy(n: int, k: int, books: List[int]) -> int:
#     books.sort(key = lambda x: x[0])
#     alice = []
#     bob = []
#     alice_and_bob = []
#     for i in range(len(books)):
#         if (books[i][1] == 1 and books[i][2] == 0):
#             alice.append(books[i][0])
#         elif (books[i][1] == 0 and books[i][2] == 1):
#             bob.append(books[i][0])
#         elif (books[i][1] == 1 and books[i][2] == 1):
#             alice_and_bob.append(books[i][0])
#
#     alice_or_bob = []
#     for i in range(min(len(alice), len(bob))):
#         alice_or_bob.append(alice[i] + bob[i])
#
#     heap = []
#
#     for i in range(len(alice_and_bob)):
#         heappush(heap, alice_and_bob[i])
#     for i in range(len(alice_or_bob)):
#         heappush(heap, alice_or_bob[i])
#
#     ans = 0
#     for _ in range(k):
#         if (heap):
#             ans += heappop(heap)
#         else:
#             return -1
#     return ans

# TLE for when Alice and Bob are reading 20k+ books. Should use a dict to optimize and add all at once.
# def readingBooks_easy(n: int, k: int, books: List[int]) -> int:
#     books.sort(key = lambda x: x[0])
#     alice = []
#     bob = []
#     alice_bob = []
#     for i in range(len(books)):
#         if (books[i][1] == 1 and books[i][2] == 0):
#             alice.append(books[i][0])
#         elif (books[i][1] == 0 and books[i][2] == 1):
#             bob.append(books[i][0])
#         elif (books[i][1] == 1 and books[i][2] == 1):
#             alice_bob.append(books[i][0])
#     ans = 0
#     for _ in range(k):
#         if ((not alice or not bob) and not alice_bob):
#             return -1
#         elif ((alice and bob) and not alice_bob):
#             ans += alice[0] + bob[0]
#             alice.pop(0)
#             bob.pop(0)
#         elif ((not alice or not bob) and alice_bob):
#             ans += alice_bob[0]
#             alice_bob.pop(0)
#         else:
#             if (alice_bob[0] < alice[0] + bob[0]):
#                 ans += alice_bob[0]
#                 alice_bob.pop(0)
#             else:
#                 ans += alice[0] + bob[0]
#                 alice.pop(0)
#                 bob.pop(0)
#     return ans

inputs = list(map(int, input().split(" ")))
n = inputs[0]
k = inputs[1]

books = []
for _ in range(n):
    books.append(list(map(int, input().split(" "))))
print(readingBooks_easy(n, k, books))