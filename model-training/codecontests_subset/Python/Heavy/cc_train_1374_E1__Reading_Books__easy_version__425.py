n,k = [int(x) for x in input().split()]

bookA = []
bookB = []
bookC = []
for i in range(n):
    a,b,c = [int(x) for x in input().split()]
    if b == c == 1:
        bookC.append((a,b,c))
    if b == 1 != c:
        bookA.append((a,b,c))
    if c == 1 != b:
        bookB.append((a,b,c))
bookA.sort(key = lambda x : x[0], reverse = True)
bookB.sort(key = lambda x : x[0], reverse = True)
bookC.sort(key = lambda x : x[0], reverse = True)

totalTime = 0
totalLikes = 0
while (True):
    if totalLikes >= k:
       break
    if len(bookA) == len(bookC) == len(bookB) == 0:
        break
    elif (len(bookC) > 0) and (len(bookA) == 0 or len(bookB) == 0 or bookC[len(bookC) - 1][0] <= bookA[len(bookA) - 1][0] + bookB[len(bookB) - 1][0]):
        totalTime += bookC[len(bookC) - 1][0]
        bookC.pop()
        totalLikes += 1
    elif len(bookA) > 0 and len(bookB) > 0:
        totalTime += bookA[len(bookA) - 1][0] + bookB[len(bookB) - 1][0]
        totalLikes += 1
        bookA.pop()
        bookB.pop()
    else:
        break
if totalLikes >= k:
    print(totalTime)
else:
    print(-1)





