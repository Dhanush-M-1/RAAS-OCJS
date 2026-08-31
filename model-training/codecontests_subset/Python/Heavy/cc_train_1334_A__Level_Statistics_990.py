t = int(input())
def game(p,c):
    flag = 'YES'
    if p[0] < c[0]:
        flag = "NO"
        return flag
    for i in range(1,n):
        if p[i] - p[i-1] == 0 and abs(c[i] - c[i-1]) != 0:
            flag = "NO"
            return flag
        if p[i] - p[i-1] < c[i] - c[i-1]:
            flag = "NO"
            return flag
        if p[i] < c[i]:
            flag = "NO"
            return flag
        elif p[i-1] > p[i]:
            flag="NO"
            return flag
        elif c[i-1] > c[i]:
            flag = 'NO'
            return flag
    return flag

for _ in range(t):
    n = int(input())
    p = []
    c = []
    for i in range(n):
        a,b = map(int,input().split())
        p.append(a)
        c.append(b)
    print(game(p,c))
