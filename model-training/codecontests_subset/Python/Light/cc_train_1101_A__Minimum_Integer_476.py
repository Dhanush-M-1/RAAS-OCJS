import sys
input = sys.stdin.readline
n = int(input())
a = [list(map(int,input().split())) for i in range(n)]
for i in range(n):
    if a[i][0] <= a[i][2] and a[i][2] <= a[i][1]:
        print((a[i][1]//a[i][2]+1)*a[i][2])
    else:
        print(a[i][2])