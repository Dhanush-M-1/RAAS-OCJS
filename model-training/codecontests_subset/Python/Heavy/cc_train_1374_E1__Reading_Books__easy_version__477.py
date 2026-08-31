import os,io
input=io.BytesIO(os.read(0,os.fstat(0).st_size)).readline

n,k = map(int,input().split())
bookA = []
bookB = []
bookAB = []
for _ in range(n):
    t,a,b = map(int,input().split())
    if a == 1 and b == 1:
        bookAB.append(t)
    elif a == 1:
        bookA.append(t)
    elif b == 1:
        bookB.append(t)
bookA.sort()
bookB.sort()
bookAB.sort()
bookASum = [0]
bookBSum = [0]
bookABSum = [0]
for elem in bookA:
    bookASum.append(bookASum[-1] + elem)
for elem in bookB:
    bookBSum.append(bookBSum[-1] + elem)
for elem in bookAB:
    bookABSum.append(bookABSum[-1] + elem)
minReadingTime = -1
for i in range(len(bookABSum)):
    if len(bookASum) > max(k - i,0) and len(bookBSum) > max(k - i,0) and len(bookABSum) > i:
        if minReadingTime == -1 or minReadingTime > bookABSum[i] + bookASum[max(k - i,0)] + bookBSum[max(k - i,0)]:
            minReadingTime = bookABSum[i] + bookASum[max(k - i,0)] + bookBSum[max(k - i,0)]
print(minReadingTime)