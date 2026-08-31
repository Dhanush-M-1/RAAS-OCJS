t = int(input())
myList = []
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    if a[0] + a[1] > a[-1]:
        myList.append([-1])
    else:
        elem = [1, 2, n]
        myList.append(elem)
for thing in myList:
    print(*thing)
