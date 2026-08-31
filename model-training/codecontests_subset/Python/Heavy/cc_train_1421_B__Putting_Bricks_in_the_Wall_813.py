k = int(input())
for i in range(k):
    ans = []
    n = int(input())
    for i in range(n):
        ans.append(input())
    a,b = ans[0][1],ans[1][0]
    c,d = ans[-1][-2],ans[-2][-1]
    flag = 0
    for q in range(0,2):
        if flag == 1:
            break
        for w in range(0,2):
            if flag == 1:
                break
            for e in range(0,2):
                if flag == 1:
                    break
                for r in range(0,2):
                    if flag:
                        break
                    ans = 0
                    if r!=int(d):
                        ans += 1
                    if e!=int(c):
                        ans += 1
                    if w!=int(b):
                        ans += 1
                    if (int(a)!=q):
                        ans += 1
                    if (q==w and e==r and q!=e) and (ans<=2):
                        print(ans)
                        if r!=int(d):
                            print(n-1,n)
                        if e!=int(c):
                            print(n,n-1)
                        if w!=int(b):
                            print(2,1)
                        if q!=int(a):
                            print(1,2)
                        flag = 1
                        break