for _ in range(int(input())):
    n,m = map(int,input().split())
    s = input()
    mark = [0] * (n + 10)
    l = [*map(int,input().split())]
    for i in range(m):
        mark[l[i]] += 1
    k = []
    count = [0] * 128
    v = [0] * 128
    for i in range(n):
        if(count[ord(s[i])] == 0):
            k.append(ord(s[i]))
        count[ord(s[i])] += 1
        while(mark[i + 1] > 0):
            for j in k:
                v[j] += count[j]
            mark[i + 1] -= 1
    for i in range(n):
        v[ord(s[i])] += 1
    for i in range(ord('a'),ord('z') + 1,1):
        print(v[i],end=" ")
    print()