import sys

input = sys.stdin.readline

if __name__ == '__main__':
    for _ in range(int(input().strip())):
        n = int(input().strip())
        arr = list(map(int, input().strip().split()))
        ne = []
        for i in range(n):
            if i == 0:
                if arr[i] == -1 and arr[i + 1] != -1:
                    ne.append(arr[i + 1])
            elif i == n - 1:
                if arr[i] == -1 and arr[i - 1] != -1:
                    ne.append(arr[i - 1])
            else:
                if arr[i] == -1:
                    if arr[i - 1] != -1:
                        ne.append(arr[i - 1])
                    if arr[i + 1] != -1:
                        ne.append(arr[i + 1])
        ne.sort()
        mi, ma = 0, 0
        if len(ne) == 1:
            mi, ma = ne[0], ne[0]
        elif len(ne) > 1:
            mi, ma = ne[0], ne[-1]
        k = (ma + mi) // 2
        ans = ma - k
        for i in range(n):
            if arr[i] == -1:
                arr[i] = k
        for i in range(n - 1):
            ans = max(ans, abs(arr[i] - arr[i + 1]))
        print(ans, k)
