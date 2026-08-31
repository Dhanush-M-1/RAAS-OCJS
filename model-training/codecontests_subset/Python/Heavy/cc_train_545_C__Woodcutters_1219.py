from random import randint

def maxNumberOfCutTreesDP(n, x, h):

    x.append(float('inf'))
    h.append(0)

    prevLeft, prevStay, prevRight = 1, 0, canFallRight(0, x, h)

    for i in range(1, n):

        left = canFallLeft(i, x, h) \
               and (1 + max(prevLeft,
                            prevStay,
                            canFallLeftIfPrevRight(i, x, h) and prevRight))

        stay  = max(prevLeft, prevStay, prevRight)

        right = canFallRight(i, x, h) \
                and (1 + max(prevLeft, prevStay, prevRight))

        prevLeft, prevStay, prevRight = left, stay, right

    return max(prevLeft, prevStay, prevRight)

def canFallLeft(i, x, h):
    return int(x[i]-h[i] > x[i-1])

def canFallRight(i, x, h):
    return int(x[i]+h[i] < x[i+1])

def canFallLeftIfPrevRight(i, x, h):
    return int(x[i-1] + h[i-1] < x[i] - h[i])


def maxNumberOfCutTreesGreedy(n, x, h):
    
    maxNumTrees = 1

    for i in range(1, n-1):

        if canFallLeft(i, x, h):
            maxNumTrees += 1

        elif canFallRight(i, x, h):
            maxNumTrees += 1
            x[i] += h[i]

    return maxNumTrees if n == 1 else maxNumTrees + 1


def getPositionsAndHeights(n):
    x, h = [],[]
    for i in range(n):
        xi, hi = map(int, input().split())
        x.append(xi)
        h.append(hi)
    return x, h

if __name__ == '__main__':
    
    n = int(input())
    x, h = getPositionsAndHeights(n)
    print(maxNumberOfCutTreesGreedy(n, x, h))


