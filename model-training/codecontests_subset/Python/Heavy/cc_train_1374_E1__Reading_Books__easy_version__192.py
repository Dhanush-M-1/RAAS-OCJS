import sys
import collections
import heapq


def get_ints(): return map(int, sys.stdin.readline().strip().split())


def main(hashtable, k):
    alice = bob = 0
    total = 0
    while alice < k or bob < k:
        if alice < k and bob < k:
            if hashtable[(1, 1)] and hashtable[(0, 1)] and hashtable[(1, 0)]:
                if hashtable[(1, 1)][0] < hashtable[(0, 1)][0] + hashtable[(1, 0)][0]:
                    total += heapq.heappop(hashtable[(1, 1)])
                    alice += 1
                    bob += 1
                else:
                    total += heapq.heappop(hashtable[(0, 1)])
                    total += heapq.heappop(hashtable[(1, 0)])
                    alice += 1
                    bob += 1
            elif hashtable[(1, 1)]:
                total += heapq.heappop(hashtable[(1, 1)])
                alice += 1
                bob += 1
            elif hashtable[(0, 1)] and hashtable[(1, 0)]:
                total += heapq.heappop(hashtable[(0, 1)])
                total += heapq.heappop(hashtable[(1, 0)])
                alice += 1
                bob += 1
            else:
                print(-1)
                return -1
    print(total)
    return total


if __name__ == "__main__":
    N, k = get_ints()
    hashtable = collections.defaultdict(list)
    for i in range(N):
        t, a, b = get_ints()
        heapq.heappush(hashtable[(a, b)], t)
    main(hashtable, k)
