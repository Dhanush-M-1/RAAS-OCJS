import sys
from bisect import bisect_left as bs

input = sys.stdin.readline

if __name__ == '__main__':
    for _ in range(int(input().strip())):
        n, m = list(map(int, input().strip().split()))
        st = input().strip()
        arr = list(map(int, input().strip().split()))
        arr.sort()
        dic = {}
        cur = 0
        last = 0
        for i in range(len(st)):
            if cur > len(arr) - 1:
                break
            last = i
            while cur < len(arr) and i + 1 > arr[cur]:
                cur += 1
            if st[i] in dic:
                dic[st[i]] += m - cur + 1
            else:
                dic[st[i]] = m - cur + 1
        for i in range(last + 1, n):
            if st[i] in dic:
                dic[st[i]] += 1
            else:
                dic[st[i]] = 1
        out = []
        for i in range(26):
            cur_ch = chr(ord('a') + i)
            if cur_ch in dic:
                out.append(dic[cur_ch])
            else:
                out.append(0)
        print(' '.join(map(str, out)))
