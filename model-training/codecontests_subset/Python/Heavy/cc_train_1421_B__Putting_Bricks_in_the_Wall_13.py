def sa(): return map(int,input().split())
def ra(): return list(map(int,input().split()))
def mati(n): return [ra() for i in range(n)]
def ri(): return int(input())
for _ in range(ri()):
    n=ri()
    g = [input() for i in range(n)]
    if g[0][1]==g[1][0]==g[-2][-1]==g[-1][-2]:
        print('2\n1 2\n2 1')
    elif g[0][1]==g[1][0] and g[-2][-1]!=g[-1][-2]:
        if g[-2][-1]==g[1][0]:
            print('1\n{} {}'.format(n-1,n))
        else:
            print('1\n{} {}'.format(n,n-1))
            
    elif g[0][1]!=g[1][0] and g[-2][-1]==g[-1][-2]:
        if g[-2][-1]==g[1][0]:
            print('1\n{} {}'.format(2,1))
        else:
            print('1\n{} {}'.format(1,2))
    elif g[0][1]!=g[1][0] and g[-2][-1]!=g[-1][-2]:
        if g[0][1]!=g[-2][-1]:
            print('2\n{} {}\n{} {}'.format(1,2,n-1,n))
        else:
            print('2\n{} {}\n{} {}'.format(1,2,n,n-1))
    else:
        print(0)
