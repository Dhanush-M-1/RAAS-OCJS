n, k = map(int, input().split())
a = sorted([int(i) for i in input().split() if k % int(i) == 0])
print(k // a[-1])