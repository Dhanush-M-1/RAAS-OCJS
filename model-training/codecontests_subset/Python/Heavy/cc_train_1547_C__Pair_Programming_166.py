t = int(input())
for _ in range(t*2):
    bb = input().split()
    if bb == []: continue
    k, n, m = int(bb[0]), int(bb[1]), int(bb[2])

    s1 = input().split()
    s2 = input().split()
    for i in range(n):
        s1[i] = int(s1[i])
    for i in range(m):
        s2[i] = int(s2[i])
    l = 0
    r = 0
    out = []
    flag = True
    n,m=m,n
    while l < m or r < n:
        if l == m:
            if s2[r] > k:
                if s2[r] == 0:
                    out.append(s2[r])
                    r+=1
                    k+=1
                else:
                    print(-1)
                    flag = False
                    break
            elif s2[r] <= k:
                out.append(s2[r])
                if s2[r] == 0: k+=1
                r +=1

        elif r == n:
            if s1[l] > k:
                if s1[l] == 0:
                    out.append(s1[l])
                    l+=1
                    k+=1
                else:
                    print(-1)
                    flag = False
                    break
            elif s1[l] <= k:
                out.append(s1[l])
                if s1[l] == 0:
                    k+=1
                l +=1
        else:
            if min(s1[l], s2[r]) > k:
                maa = min(s1[l], s2[r])
                if maa == 0:
                    out.append(maa)
                    if maa == s1[l]: l+=1
                    else: r+=1
                    k +=1
                else:
                    print(-1)
                    flag = False
                    break
            elif min(s1[l], s2[r]) <= k:
                maa = min(s1[l], s2[r])
                if maa == 0: k+=1
                out.append(maa)
                if maa == s1[l]:
                    l += 1
                else:
                    r += 1

    if flag == False: continue
    print(*out)





