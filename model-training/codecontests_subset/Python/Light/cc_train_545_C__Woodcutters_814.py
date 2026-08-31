from sys import stdin
n = int(input())
l = [[] for i in range(n)]

for i in range(n):
    l1 = list(map(int, stdin.readline().rstrip().split(" ")))
    l[i] = l1

t = l[0][0]
c= 2
if n < 3:
    print(n)
else:
    for i in range(1, n-1):
        x, h = l[i][0], l[i][1]
        if x - h > t:
            c+=1
            t = x
        elif x + h < l[i+1][0]:
            c+=1
            t = x+h
        else:
            t = x
    print(c)