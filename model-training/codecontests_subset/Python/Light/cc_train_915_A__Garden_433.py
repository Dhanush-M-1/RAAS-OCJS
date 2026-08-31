n, c = map(int, input().split())
a = list(map(int, input().split()))
a.sort(reverse = True)
for i in a:
    if c % i == 0:
        print(c // i)
        break