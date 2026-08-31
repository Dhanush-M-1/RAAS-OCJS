


t = int(input())
for i in range(t):
    n,m = list(map(int, input().split()))
    s = input()
    p = list(map(int, input().split()))
    prefix = [[0]*26 for i in range(n)]
    #print(ord("a")-97)
    prefix[0][ord(s[0])-97] = 1
    for i in range(1,n):
        prefix[i] = prefix[i-1][:]
        prefix[i][ord(s[i])-97] += 1

    ans = [0]*26
    for i in range(m):
        c = prefix[p[i]-1]
        #print(c, p[i])
        for j in range(26):
            ans[j] += c[j]
    for j in range(26):
        ans[j] += prefix[-1][j]
    print(" ".join(list(map(str, ans))))


