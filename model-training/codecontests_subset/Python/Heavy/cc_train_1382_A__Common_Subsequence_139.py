from sys import stdin
input = stdin.readline

lines = int(input())

for i in range(lines):
    a,b = (map(int, input().split()))
    x = list(map(int, input().split()))
    y = list(map(int, input().split()))
    didprint = False
    if len(x) == 1 and len(y)==1 and x[0] != y[0]:
        print("NO")
        didprint = True
    else:
        for j in range(a):
            if x[j] in y:
                print("YES")
                print("1", x[j])
                didprint = True
                break
    if didprint == False:
        print("NO")