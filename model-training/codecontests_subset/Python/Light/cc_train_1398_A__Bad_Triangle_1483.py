from sys import stdin, stdout


def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        arr = list(map(int, stdin.readline().split()))
        if arr[n - 1] >= arr[0] + arr[1]:
            print(1, 2, n)
        else:
            print(-1)


main()