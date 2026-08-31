from collections import defaultdict,deque,Counter,OrderedDict
from heapq import heappop,heappush
def main():
    n,ans = int(input()),2
    a = [tuple(map(int,input().split())) for i in range(n)]
    last = a[0][0]
    ans = min(2,n)
    for i in range(1,n-1):
        if a[i][0]-a[i][1] > last:
            ans += 1
            last = a[i][0]
        elif a[i][0]+a[i][1] < a[i+1][0]:
            last = a[i][0]+a[i][1]
            ans += 1
        else:
            last = a[i][0]
    print(ans)


if __name__ == "__main__":
    main()