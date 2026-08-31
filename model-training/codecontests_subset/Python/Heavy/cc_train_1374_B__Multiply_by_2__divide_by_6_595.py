from sys import stdin
input = stdin.readline

for _ in range(int(input())):
    n = int(input())
    cnt2, cnt3 = 0, 0

    if n == 1:
        print(0)
        continue

    k = n

    while k > 1:
        if k % 2 == 0:
            cnt2 += 1
            k //= 2
        else:
            break

    while k > 1:
        if k % 3 == 0:
            cnt3 += 1
            k //= 3
        else:
            break

    if k != 1:
        print(-1)
        continue

    if cnt3 < cnt2:
        print(-1)
        continue

    print(cnt3 * 2 - cnt2)