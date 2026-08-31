q = int(input())
x = []
for i in range(q):
    li,ri,di = map(int,input().split())
    if (di < li):
        x.append(di)
    elif (di > ri):
        x.append(di)
    else:
        x.append(di * ((ri // di) + 1))
for i in range(q):
    print(x[i])
