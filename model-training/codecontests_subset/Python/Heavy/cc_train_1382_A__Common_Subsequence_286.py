from collections import defaultdict

for _ in range(int(input())):
    n,k = map(int,input().split())
    l1 = list(map(int,input().split()))
    l2 = list(map(int,input().split()))
    l1.sort()
    l2.sort()
    l1 = list(set(l1))
    l2 = list(set(l2))
    d = defaultdict(lambda:0)

    for i in range(len(l1)):
        d[l1[i]] += 1
    for i in range(len(l2)):
        d[l2[i]] += 1


    f = 0
    ans = -1
    for i,j in d.items():
        if j > 1:
            f = 1
            ans = i
            break

    if f == 1:
        print("YES")
        print(1,ans)
    else:
        print("NO")
