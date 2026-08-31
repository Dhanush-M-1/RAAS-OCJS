q=int(input())
for _ in range(q):
    l,r,d=[int(x) for x in input().split()]
    c=0
    if d<l:
        print(d)
        continue

    i=(r//d)*d+d
    print(i)