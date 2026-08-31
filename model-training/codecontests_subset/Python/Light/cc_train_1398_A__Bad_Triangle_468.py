T = int(input())
for _ in range(T):
    input()
    l = list(map(int,input().split()))
    for i in range(len(l)):
        l[i] = (l[i], i)
    l.sort()
    if l[0][0] + l[1][0] <= l[-1][0]:
        print(l[0][1] + 1, l[1][1] + 1, l[-1][1] + 1)
    else:
        print(-1)

