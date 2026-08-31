def solve(l,r,d):
    if l//d > 1:
        return d
    elif(l//d== 1 and l!=d):
        return d
    else:
        return ((r//d) + 1)*d

t = int(input())
for _ in range(t):
    l,r,d = map(int,input().split())
    print(solve(l,r,d))