def test(a, b, c):
    if a+b <= c or b+c <= a or a+c <= b:
        return False
    return True


n = int(input())
ans = []
for i in range(n):
    key = True
    n = int(input())
    a, b, c = 0, 1, n-1
    m = [int(j) for j in input().split()]
    for j in range(1, n-1):
        b = j
        if not test(m[a], m[b], m[c]):
            key = False
            break
    if key:
        ans.append([-1])
    else:
        ans.append([a+1, b+1, c+1])
for i in ans:
    print(*i)
