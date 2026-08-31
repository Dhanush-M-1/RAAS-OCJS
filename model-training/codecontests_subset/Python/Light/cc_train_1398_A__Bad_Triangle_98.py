for _ in range(int(input())):
    n = int(input())
    b = list(map(int, input().split()))
    ans = False

    for i in range(2, len(b)):
        if b[0]+b[1] <= b[i]:
            ans = True
            print(1, 2, i+1)
            break

    if ans == False:
        print(-1)
