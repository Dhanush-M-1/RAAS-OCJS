# https://codeforces.com/problemset/problem/1398/A

for _ in range(int(input())):
    n = input()
    lengths = tuple(map(int, input().split()))

    if lengths[0] + lengths[1] > lengths[-1]:
        print(-1)
    else:
        print(1, 2, n)