from sys import stdin, stdout


def count(arr, res, lo, hi, level):
    if lo < hi:
        m = 0
        mi = -1
        for i in range(lo, hi):
            if arr[i] > m:
                m = arr[i]
                mi = i
        res[mi] = level
        count(arr, res, lo, mi, level+1)
        count(arr, res, mi+1, hi, level+1)


def main():
    t = int(stdin.readline())
    for _ in range(t):
        n = int(stdin.readline())
        arr = list(map(int, stdin.readline().split()))
        res = [0] * len(arr)
        count(arr, res, 0, n, 0)
        stdout.write('%s\n' % ' '.join(map(str, res)))


main()
