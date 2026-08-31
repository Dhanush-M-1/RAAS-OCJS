_, k = map(int, input().split())

for a in sorted(map(int, input().split()), reverse=True):
    if k % a == 0:
        print(k // a)
        break