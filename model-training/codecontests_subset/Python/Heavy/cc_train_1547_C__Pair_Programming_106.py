from sys import stdin, stdout
ip = lambda : stdin.readline().rstrip("\r\n")
ips = lambda : ip().split()
out = lambda x, end='\n': stdout.write(str(x)+end)

for _ in range(int(ip())):
    s = ip()
    k,n,m = map(int, ips())
    a = list(map(int, ips()))
    b = list(map(int, ips()))
    i, j = 0, 0
    ans = []
    while i<n or j<m:
        if i<n:
            if a[i] == 0:
                k += 1
                ans.append(0)
                i += 1
            elif k>=a[i]:
                ans.append(a[i])
                i += 1
            else:
                if j<m:
                    if b[j] == 0:
                        k += 1
                        ans.append(0)
                        j += 1
                    elif k>=b[j]:
                        ans.append(b[j])
                        j += 1
                    else:
                        out(-1)
                        break
                else:
                    out(-1)
                    break
        elif j<m:
            if b[j] == 0:
                k += 1
                ans.append(0)
                j += 1
            elif k>=b[j]:
                ans.append(b[j])
                j += 1
            else:
                out(-1)
                break
    else:   
        print(*ans)