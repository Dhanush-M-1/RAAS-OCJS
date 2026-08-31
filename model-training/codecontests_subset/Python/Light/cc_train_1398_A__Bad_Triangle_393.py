t = int(input())

for _ in range(t):
    n = input()
    a = [int(x) for x in input().split()]
    if a[-1] >= (a[0] + a[1]):
        print("1 2 "+n)
    else:
        print("-1")
