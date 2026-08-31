def run(k, a):
    a.sort(reverse=True)
    for x in a:
        if k % x == 0:
            return k // x


n, k = map(int, input().split())
a = list(map(int, input().split()))
print(run(k, a))
