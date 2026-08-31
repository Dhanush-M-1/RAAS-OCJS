n, s = list(map(int , input().split()))
arr = input().split()
countm, countb, counte, ans = 0, 0, 0, 0
for i in range(len(arr)):
    arr[i] = int(arr[i])
    if arr[i] < s:
        countm += 1
    elif arr[i] > s:
        countb += 1
    else:
        counte += 1
arr.sort()
if countm > countb:
    i = countm - 1 
    while (countb+counte-1) < countm:
        ans += s - arr[i]
        i -= 1
        counte += 1
        countm -= 1
elif countb > countm:
    i = countm+counte
    while (countm + counte-1) < countb:
        ans += arr[i] - s
        i += 1
        counte += 1
        countb -= 1
print(ans)