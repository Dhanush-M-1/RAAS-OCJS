def solve():
    ans = a
    candles = a
    remainder = 0
    while (candles+remainder)//b > 0:
        copy = candles+remainder
        candles = (candles+remainder)//b
        remainder = copy % b
        ans += candles
    return ans

if __name__ == '__main__':
    a, b = map(int, input().split())
    print(solve())