n, k = [int(x) for x in input().split()]
key = 1
answer = k
i = 0
b = list(map(int, input().split()))
while(n > 0):
    a = b[i]
    if (k % a == 0 and answer > (k / a)):
        answer = k / a
    n -= 1
    i += 1
print(int(answer))
