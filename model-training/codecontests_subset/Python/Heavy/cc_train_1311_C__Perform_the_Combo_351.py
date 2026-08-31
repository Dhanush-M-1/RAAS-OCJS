t = int(input())
dic = dict()
r = 'abcdefghijklmnopqrstuvwxyz'
for _ in range(t):
    dic = dict()
    for i in r:
        dic[i] = 0
    dicp = dict()
    ans = dict(dic)
    n,m = map(int,input().split())
    s = input()
    l = list(map(int,input().split()))
    for i in range(n):
        dic[s[i]] += 1
        dicp[i+1] = dict(dic)
    for i in l:
        ch = dicp[i]
        for j in r:
            ans[j] += ch[j]
    ch = dicp[n]
    for i in r:
        ans[i] += ch[i]
    for i in r:
        print(ans[i],end = " ") 
    print()