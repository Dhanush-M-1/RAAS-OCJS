import math

if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        input()
        k, n, m = map(int, input().split())
        a = [int(x) for x in input().split()]
        b = [int(x) for x in input().split()]

        za = a.count(0)
        zeros = za + b.count(0)
        ma = max(a)
        g = max(ma, max(b))
        if k + zeros < g:
            print(-1)
        else:
            c = []
            ans = True
            i, j = 0, 0
            while True:
                if i < n and j < m:
                    if min(a[i], b[j]) > k:
                        ans = False
                        break
                    if min(a[i], b[j]) == 0:
                        k += 1
                    if a[i] > b[j]:
                        c.append(b[j])
                        j += 1
                    else:
                        c.append(a[i])
                        i += 1
                else:
                    if i == n and j == m:
                        break
                    if i == n:
                        if b[j] == 0:
                            k += 1
                        elif b[j] > k:
                            ans = False
                            break
                        c.append(b[j])
                        j += 1
                    elif j == m:
                        if a[i] == 0:
                            k += 1
                        elif a[i] > k:
                            ans = False
                            break
                        c.append(a[i])
                        i += 1
                    else:
                        break
            if ans:
                for x in c:
                    print(x, end=' ')
                print()
            else:
                print(-1)