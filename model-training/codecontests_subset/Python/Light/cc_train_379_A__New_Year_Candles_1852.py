if __name__ == "__main__":
    n, d = map(int, input().split())
    tsum = n
    while n >= d:
        tsum += n//d
        n = (n//d) + (n%d)
    print(tsum)