import sys


def main():
    res = ''
    input = sys.stdin.readline
    print = sys.stdout.write
    t = int(input())
    for _ in range(t):
        n = int(input())
        a = list(map(int, input().split()))
        if a[0] + a[1] <= a[n - 1]:
            sub_res = f'{1} {2} {n}\n'
        else:
            sub_res = '-1\n'
        res += sub_res
    print(res)


main()