import sys
from heapq import heappop, heappush
def main():
    def input(): return sys.stdin.readline().rstrip()
    n = int(input())
    l_camel = [[] for _ in range(n)]
    r_camel = [[] for _ in range(n)]
    ans = 0
    for _ in range(n):
        k, l, r = map(int, input().split())
        if l >= r:
            ans += r
            l_camel[k-1].append(l-r)
        else:
            ans += l
            r_camel[~(k-1)].append(r-l)
    
    cur = 0
    que = []
    for i in range(n):
        for el in l_camel[i]:
            heappush(que, el)
        while len(que) > i+1:
            heappop(que)
    ans += sum(que)

    que = []
    for i in range(n):
        for el in r_camel[i]:
            heappush(que, el)
        while len(que) > i:
            heappop(que)
    ans += sum(que)
    print(ans)


if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        main()