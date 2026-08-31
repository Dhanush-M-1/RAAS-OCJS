test_cases = int(input())
for _ in range(test_cases):
    n = int(input())
    a = [int(i) for i in input().split(" ")]
    if(a[0] + a[1] <= a[n - 1]):
        print(1, 2, n)
    else:
        print(-1)