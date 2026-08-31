def solve(l,n):
    p1,c1 = l[0][0],l[0][1]
    f = 0
    if p1<c1:
        f = 1
    if f==0:
        for j in range(1,n):
            if p1<=l[j][0] and c1<=l[j][1]:
                if l[j][0]-p1>=l[j][1]-c1 and l[j][1]<=l[j][0]:
                    p1,c1 = l[j][0],l[j][1]
                    continue
                else:
                    f = 1
                    break
            else:
                f = 1
                break
    if f==0:
        print('YES')
    else:
        print('NO')

if __name__ == '__main__':
    t = int(input())
    for i in range(t):
        n = int(input())
        l = []
        for j in range(n):
            p,c = map(int,input().split())
            l.append([p,c])
        solve(l,n)