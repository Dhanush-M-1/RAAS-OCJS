#!/usr/bin/env python3

def main():
    for _ in range(int(input())):
        n = int(input())
        a = sorted(map(int, input().split()))
        if a[0] + a[1] <= a[-1]:
            print(1, 2, n)
        else:
            print(-1)

if __name__ == "__main__":
    main()
