n, k = map(int, input().split())
a = list(map(int, input().split()))
answer = None

a.sort()

for item in a:
    if (k % item == 0):
        answer = k // item

print(answer)
