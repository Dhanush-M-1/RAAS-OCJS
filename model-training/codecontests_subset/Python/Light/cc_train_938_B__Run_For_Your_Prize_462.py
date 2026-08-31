N = int(input())
A = list(map(int, input().split()))

curM = 0

for a in A:
    curM = max(curM, min(a - 1, 1000000 - a))
print(curM)    