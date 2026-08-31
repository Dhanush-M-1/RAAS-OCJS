n, k = list(map(int, input().strip().split()))
a = list(map(int, input().strip().split()))

answer = float('inf')
for i in a:
    if k % i == 0:
        answer = min(answer, k // i)

print(answer)