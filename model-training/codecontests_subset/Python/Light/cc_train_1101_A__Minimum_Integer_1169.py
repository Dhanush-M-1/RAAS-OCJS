from sys import stdin, stdout
input = stdin.readline
print = stdout.write
listin = lambda : list(map(int, input().split()))
mapin = lambda : map(int, input().split())
for _ in range(int(input())):
    l, r, d = mapin()
    if d < l:
        print(str(d)+'\n')
    else:
        print(str(r+d - r%d)+'\n')