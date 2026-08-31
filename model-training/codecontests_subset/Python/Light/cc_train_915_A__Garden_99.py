(n, k) = list(map(int, input().split()))

s = list(map(int, input().split()))
s.sort(reverse=True)
for a in s:
    if k % a == 0:
        print(k // a)
        break