from collections import deque
for _ in range(int(input())):
    blank = input()
    k, n, m = map(int, input().split())
    a = deque(map(int, input().split()))
    b = deque(map(int, input().split()))

    ans = []
    fail = False

    while a and b:
        next_a = a[0]
        next_b = b[0]

        if next_a == 0:
            ans.append(0)
            k += 1
            a.popleft()
        elif next_b == 0:
            ans.append(0)
            k += 1
            b.popleft()
        elif next_a <= next_b:
            if next_a <= k:
                ans.append(next_a)
                a.popleft()
            else:
                fail = True
                break
        else:
            if next_b <= k:
                ans.append(next_b)
                b.popleft()
            else:
                fail = True
                break
    else:
        while a:
            next_a = a[0]
            if next_a == 0:
                ans.append(0)
                k += 1
                a.popleft()
            else:
                if next_a <= k:
                    ans.append(next_a)
                    a.popleft()
                else:
                    fail = True
                    break

        while b:
            next_b = b[0]
            if next_b == 0:
                ans.append(0)
                k += 1
                b.popleft()
            else:
                if next_b <= k:
                    ans.append(next_b)
                    b.popleft()
                else:
                    fail = True
                    break
    if not fail:
        print(*ans)
    else:
        print(-1)