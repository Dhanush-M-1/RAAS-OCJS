from sys import stdin, stdout
input = stdin.readline
#print = stdout.write

for _ in range(int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    b = [(a[i],i+1) for i in range(len(a))]
    b.sort(key = lambda x: x[0])
    if b[0][0]+b[1][0]<=b[-1][0]:
        t = b[0][1],b[1][1], b[-1][1]
        print(*sorted(t), sep=' ')
    else:
        print(-1)