for _ in range(int(input())):
    input()
    k, m, n = map(int, input().split())
    l = list(map(int, input().split()))
    r = list(map(int, input().split()))
    i = j = 0
    ans = []
    flag = True
    while i<len(l) and j<len(r):
        if l[i] == 0:
            ans.append(0)
            k+=1
            i+=1
        elif r[j] == 0:
            ans.append(0)
            j+=1
            k+=1
        elif l[i]<=k:
            ans.append(l[i])
            i+=1
        elif r[j]<=k:
            ans.append(r[j])
            j+=1
        else:
            flag = False
            break
    if flag:
       while i<len(l):
           if l[i]<=k:
                ans.append(l[i])
                if l[i] == 0:
                    k+=1
                i+=1
           else:
                flag = False
                break
       while j<len(r):
           if r[j]<=k:
                ans.append(r[j])
                if r[j] == 0:
                    k+=1
                j+=1
           else:
                flag = False
                break
    if not flag:
        print(-1)
    else:
        print(*ans)
