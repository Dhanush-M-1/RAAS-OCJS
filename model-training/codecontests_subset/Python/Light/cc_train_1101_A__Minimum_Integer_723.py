t = int(input())
for _ in range(t):
    l1 = [int(x) for x in input().split()]
    l,r,d = l1[0],l1[1],l1[2]
    if d<l:
        print(d)
    else:
        print(r+d-r%d)