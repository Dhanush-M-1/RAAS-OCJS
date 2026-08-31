t = int(input())

for _ in range(t):
    n, m = tuple(map(int, input().split()))
    s = input()
    p = list(map(int, input().split()))

    histogram = [0 for i in range(n)]
    for pp in p:
        histogram[pp-1] += 1
    histogram[-1] = 1

    sum = 0
    for i in range(n-1, -1, -1):
        sum += histogram[i]
        histogram[i] = sum

    result = [0 for i in range(ord('z') - ord('a') + 1)]
    for i in range(n):
        result[ord(s[i])-ord('a')] += histogram[i]

    print(" ".join(map(str,result)))

