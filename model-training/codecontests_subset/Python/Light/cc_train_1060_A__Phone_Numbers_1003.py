import collections


def solve():
    n = int(input())
    cards = collections.Counter(input())
    eights = cards['8']
    ans: int = min(eights, n // 11)
    print(ans)


if __name__ == '__main__':
    solve()
