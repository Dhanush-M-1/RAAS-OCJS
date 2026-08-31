n = int(input())
a = list(map(int, input().split()))
chetarr = []
nechetarr = []
chet = 0
nechet = 0
for i in range(n):
    if a[i] % 2 == 0:
        chet += 1
        chetarr.append(a[i])
    else:
        nechet += 1
        nechetarr.append(a[i])

sum = 0
if (chet == nechet) or ((chet+1) == nechet) or ((chet-1)==nechet):
    print(sum)
else:
    if chet > nechet:
        for i in range(chet-nechet-1):
            sum += min(chetarr)
            chetarr.remove(min(chetarr))
    else:
        for i in range(nechet-chet-1):
            sum += min(nechetarr)
            nechetarr.remove(min(nechetarr))
    print(sum)

