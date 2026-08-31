T = int(input())

for _ in range(T):
    n = int(input())
    data = list(map(int, input().split()))
    if sum(data[0:2]) > data[-1]:
        print(-1)
    else:
        impos = False
        for i in range(len(data)-1):
            a, b = data[i:i+2]
            isPos = False
            for j in range(i+2, n):
                c = data[j]
                if (a+b) <= c:  # impos
                    print(i+1, i+2, j+1)
                    impos = True
                    isPos = True
                    break
            if isPos:
                break
        if not impos:
            print(-1)
