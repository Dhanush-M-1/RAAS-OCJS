a = int(input())
for i in range(a):
    b = list(int(x) for x in input().split())
    l = b[0]
    r = b[1]
    d = b[2]
    if l>d:
        print(d)
    elif d>r:
        print(d)
    else:
        print(d*(r//d+1))