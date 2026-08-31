t=int(input())
for _ in range(t):
    _ = input()
    k,n,m = [int(x) for x in input().split()]
    a = [int(x) for x in input().split()]
    b = [int(x) for x in input().split()]
    buf = []
    for _ in range(n+m):
        if len(a)==0 or len(b) == 0:
            if len(a)==0:
                buf.extend(b)
                break
            else:
                buf.extend(a)
                break
        if a[0]>=b[0]:
            buf.append(b[0])
            b = b[1:]
        else:
            buf.append(a[0])
            a = a[1:]
    cop = buf[:]
    for i in range(n+m):
        x = cop[0]
        cop = cop[1:]
        if x == 0:
            k+=1
        if x>k:
            print(-1)
            break
        if i == n+m-1:
            print(*buf)