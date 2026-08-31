n, k = map(int, input().split())
a = sorted(list(map(int, input().split())), reverse = True)
for i in a:
    if k % i == 0:
        print(k // i)
        break
