# 0379A - New Year Candles
# https://codeforces.com/problemset/problem/379/A
# https://atcoder.jp/contests/arc011/tasks/arc011_1
def main():
    a, b = tuple(map(int, input().rstrip().split()))
    ans = a
    while a >= b:
        ans += a // b
        a = a // b + a % b
    print(ans)


if __name__ == "__main__":
    main()