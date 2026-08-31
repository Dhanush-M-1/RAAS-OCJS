test_cnt = int(input())
for tn in range(test_cnt):
    n = int(input())
    a = list(map(int, input().split()))
    if a[0]+a[1] <= a[-1]:
        print(1, 2, n)
    else:
        print(-1)



            