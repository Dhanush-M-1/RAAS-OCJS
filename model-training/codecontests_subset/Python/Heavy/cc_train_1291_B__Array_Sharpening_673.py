T = int(input())
answer = ""

for t in range(T):

    n = int(input())
    arr = list(map(int, input().split(' ')))
    end = False

    can = 0

    if n == 1:
        answer += "Yes\n"
        continue

    for i in range(n-1, -1, -1):
        if arr[i] >= n - i - 1:
            can += 1
        else:
            break

    l = -1
    r = n
    for i in range(n):
        if i > 0:
            if arr[i-1] < i-1:
                answer += "No\n"
                end = True
                break

        r -= 1
        l += 1
        if l <= arr[i] and r <= arr[i] and r <= can:
            answer += "Yes\n"
            end = True
            break

    if not end:
        answer += "No\n"

print(answer)