# でつoO(YOU PLAY WITH THE CARDS YOU'RE DEALT..)
from heapq import heappush, heappop
import sys
def main(N, KLR):
    LL = [(-(l - r), k - 1) for k, l, r in KLR if l >= r and k < N]
    RR = [(-(r - l), N - k - 1) for k, l, r in KLR if l < r and k < N]
    ans = sum(l for k, l, r in KLR if k >= N)
    ans += sum(min(l, r) for k, l, r in KLR if k != N)
    for L in (LL, RR):
        M = len(L)
        L.sort(key=lambda x: x[1], reverse=True)
        q = []
        j = 0
        for i in range(N - 1, -1, -1):
            while j < M and L[j][1] >= i:
                heappush(q, L[j][0])
                j += 1
            if q:
                ans += -heappop(q)
    return ans

if __name__ == '__main__':
    input = sys.stdin.readline
    T = int(input())
    for i in range(T):
        N = int(input())
        KLR = [tuple(map(int, input().split())) for _ in range(N)]
        ans = main(N, KLR)
        print(ans)
