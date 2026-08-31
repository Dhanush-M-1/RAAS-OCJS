q = int(input())

for _ in range(q):
    l,r,d = [int(x) for x in input().split()]
    if l > d:
        print(d)
    else:
        print(((r//d)+1)*d)
