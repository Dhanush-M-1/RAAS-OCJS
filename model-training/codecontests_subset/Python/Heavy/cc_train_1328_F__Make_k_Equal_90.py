def div(x, a):
    left = -1
    right = 64
    while right - left > 1:
        mid = (right + left) // 2
        if x // pow(2, mid) <= a:
            right = mid
        else:
            left = mid
    return right


n, k = map(int, input().split())
x = [int(x) for x in input().split()]
x.sort()
answer = pow(10, 100)
for i in range(len(x)):
    t = x[i]
    divs = 0
    isDivisible = True
    while isDivisible:
        cnt = 1
        temp = divs
        for j in range(len(x)):
            #print(x[i], ' to ', t,' and ', x[j], ' got ', temp, ' count ', cnt)
            if i == j or x[j] < t or cnt == k:
                continue
            a = div(x[j], t)
            if x[j] // pow(2, a) == t:
                cnt += 1
                temp += a
        if cnt == k:
            answer = min(temp, answer)
        if t == 0:
            isDivisible = False
        t //= 2
        divs += 1
print(answer)