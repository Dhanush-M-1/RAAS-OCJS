'''
1
4 2
'''
def mi():
    return map(int,  input().split())
'''
6
3
0 0
1 1
1 2
2
1 0
1000 3
4
10 1
15 2
10 2
15 2
1
765 432
2
4 4
4 3
5
0 0
1 0
1 0
1 0
1 0
'''
for _ in range(int(input())):
    n = int(input())
    p,c = [0]*n, [0]*n
    for i in range(n):
        p[i],c[i] = mi()
    f=1
    for i in range(n):
        if c[i]>p[i]:
            f=0
            break
        if i>=1 and (p[i]<p[i-1] or c[i]<c[i-1] or (p[i]==p[i-1] and c[i]>c[i-1]) or (p[i]-p[i-1])<(c[i]-c[i-1])):
            f=0
            break
    if f:
        print('YES')
    else:
        print('NO')