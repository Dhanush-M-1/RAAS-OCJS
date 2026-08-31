
if __name__ == "__main__":
    n = int(input())
    a = [int(i) for i in input().split()]
    print(max([int(1e6 - i) if i > (1e6 / 2) else i-1 for i in a]))