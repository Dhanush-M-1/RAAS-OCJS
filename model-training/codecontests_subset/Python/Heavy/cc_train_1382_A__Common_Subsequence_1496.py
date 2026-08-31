#!/usr/bin/env python3

def solve(a, b):
    ans = []
    # Set everything in a equal to last element
    # Up to n - 1
    for i in range(len(a) - 1):
        if a[i] != a[i + 1]:
            ans.append(i + 1)

    curr = a[-1]
    for i in range(len(a) - 1, -1, -1):
        if curr != b[i]:
            ans.append(i + 1)
            curr = not curr

    print(len(ans), " ".join(map(str, ans)))

def main():
    t = int(input())
    for _ in range(t):
        n, m = list(map(int, input().split()))
        a = list(map(int, input().split()))
        b = list(map(int, input().split()))
        x = sorted(set(a).intersection(set(b)))
        if x == []:
            print("NO")
        else:
            print("YES")
            print(1, x[0])


if __name__ == "__main__":
    main()
