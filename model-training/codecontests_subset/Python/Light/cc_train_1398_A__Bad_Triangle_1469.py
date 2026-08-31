tests = int(input())
for t in range(tests):
    n = int(input())
    ls = list(map(int, input().split()))
    if ls[0] + ls[1] <= ls[-1]:
        print(f"1 2 {n}")
    else:
        print(-1)