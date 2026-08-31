test_cases = int(input())
for tests in range(0, test_cases):
    n = int(input())
    l = list(map(int, input().split()))
    if l[0] + l[1] <= l[n - 1]:
        print(f"1 2 {n}")
    else:
        print(-1)

