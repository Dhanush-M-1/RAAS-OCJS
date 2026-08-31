n = int(input())
for i in range(n):
    s, e, d = [int(j) for j in input().split()]
    if s>d:
        print(d)
    elif e%d==0:
        print(e + d)
    else:
        print((e//d+1)*d)