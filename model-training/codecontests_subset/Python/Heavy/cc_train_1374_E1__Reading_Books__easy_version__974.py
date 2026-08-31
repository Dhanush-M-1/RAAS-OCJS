# import os,io
# input=io.BytesIO(os.read(0,os.fstat(0).st_size)).readline

n,m,k = map(int,input().split())
bookA = []
bookB = []
bookAB = []
book = []
for i in range(n):
    t,a,b = map(int,input().split())
    if a == 1 and b == 1:
        bookAB.append((t,i))
    elif a == 1:
        bookA.append((t,i))
        book.append((t,i))
    elif b == 1:
        bookB.append((t,i))
        book.append((t,i))
    else:
        book.append((t,i))
bookA.sort(key =  lambda x:x[0])
bookB.sort(key = lambda x:x[0])
bookAB.sort(key =  lambda x:x[0])
book.sort(key = lambda x:x[0])
bookAIndex = 0
bookBIndex = 0
bookALocation = []
bookBLocation = []
for i in range(len(book)):
    if bookAIndex < len(bookA) and bookA[bookAIndex] == book[i]:
        bookALocation.append(i)
        bookAIndex += 1
    if bookBIndex < len(bookB) and bookB[bookBIndex] == book[i]:
        bookBLocation.append(i)
        bookBIndex += 1
bookACount = 0
bookBCount = 0
bookCount = [(0,0)] # bookCount[i] stores how many bookA and how many bookB are in first i books
for i in range(len(book)):
    if bookACount < len(bookALocation) and bookALocation[bookACount] == i:
        bookACount += 1
    if bookBCount < len(bookBLocation) and bookBLocation[bookBCount] == i:
        bookBCount += 1
    bookCount.append((bookACount,bookBCount))

bookASum = [0]
bookBSum = [0]
bookABSum = [0]
bookSum = [0]
for elem in bookA:
    bookASum.append(bookASum[-1] + elem[0])
for elem in bookB:
    bookBSum.append(bookBSum[-1] + elem[0])
for elem in bookAB:
    bookABSum.append(bookABSum[-1] + elem[0])
for elem in book:
    bookSum.append(bookSum[-1] + elem[0])
minReadingTime = -1
for i in range(len(bookABSum)):
    if len(bookA) >= k - i and len(bookB) >= k - i and 2 * k - i <= m and m >= i:
        goalbookCount = m - i - 2 * max(k-i,0)
        high = len(book)
        low = goalbookCount
        isPossible = True
        while True:
            if high < low:
                isPossible = False
                break
            mid = (high + low) // 2
            curBookCount = mid - min(max(k-i,0),bookCount[mid][0]) - min(max(k-i,0),bookCount[mid][1])
            if curBookCount == goalbookCount:
                if high == low:
                    break
                high = mid
            else:
                if high == low:
                    isPossible = False
                    break
                else:
                    if curBookCount > goalbookCount:
                        high = mid - 1
                    else:
                        low = mid + 1

        if isPossible and (minReadingTime == -1 or minReadingTime > bookABSum[i] + bookASum[max(k-i,0)] +
            bookBSum[max(k-i,0)] + bookSum[mid] - bookASum[min(max(k-i,0),bookCount[mid][0])] - bookBSum[min(max(k-i,0),bookCount[mid][1])]):

            minReadingTime = bookABSum[i] + bookASum[max(k-i,0)] + bookBSum[max(k-i,0)] + bookSum[mid] - bookASum[min(max(k-i,0),bookCount[mid][0])] - bookBSum[min(max(k-i,0),bookCount[mid][1])]
            minIndicies = (i,max(k-i,0),mid,min(max(k-i,0),bookCount[mid][0]),min(max(k-i,0),bookCount[mid][1]))
print(minReadingTime)
printList = []
if minReadingTime != -1:
    for i in range(minIndicies[0]):
        printList.append(str(bookAB[i][1] + 1))
    for i in range(minIndicies[2]):
        printList.append(str(book[i][1] + 1))
    for i in range(minIndicies[3],minIndicies[1]):
        printList.append(str(bookA[i][1] + 1))
    for i in range(minIndicies[4],minIndicies[1]):
        printList.append(str(bookB[i][1] + 1))
print(' '.join(printList))