def getInts():
    return [int(s) for s in input().split()]

def getInt():
    return int(input())

def getStrs():
    return [s for s in input().split()]

def getStr():
    return input()

def listStr():
    return list(input())

def solve():
    N = getInt()
    trees = []
    for n in range(N):
        trees.append(tuple(getInts()))
    dp = []
    for n in range(N):
        if n == 0:
            dp.append((1,trees[0][0]))
        else:
            cur_max, right = dp[-1]
            x, h = trees[n]
            if x-h > right and x-h > trees[n-1][0]:
                dp.append((cur_max+1,x))
            elif x > right and (n == N-1 or trees[n+1][0] > x+h):
                dp.append((cur_max+1,x+h))
            else:
                dp.append((cur_max,right))
    return dp[-1][0]
    
ans = solve()
print(ans)
    
    