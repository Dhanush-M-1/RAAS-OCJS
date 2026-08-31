def OK(n, a, b):
    for i in range(1, n+1):
        if a[i] < a[i-1] or b[i] < b[i-1]:
            return False
        if a[i] == a[i-1] and b[i] != b[i-1]:
            return False
        if a[i] > a[i-1] and b[i] - b[i-1] > a[i] - a[i-1]:
            return False
    return True

t = int(input())

for k in range(t):
    n = int(input())
    #print(k+1, "--\n", n)

    a = [0]
    b = [0]
    for i in range(n):
        aa, bb = map(int, input().split())
        a.append(aa)
        b.append(bb)

    if OK(n, a, b):
        print("YES")
    else:
        print("NO")

