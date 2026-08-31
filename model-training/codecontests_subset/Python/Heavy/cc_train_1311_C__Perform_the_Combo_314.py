
t = int(input())
alp = "abcdefghijklmnopqrstuvwxyz"
dic = {}

for i in range(26):
    dic[alp[i]] = i

for loop in range(t):

    n,m = map(int,input().split())

    s = input()
    p = list(map(int,input().split()))

    p.sort()
    p.append(n)
    p.append(float("inf"))
    ind = 0

    ans = [0] * 26
    now = [0] * 26

    for i in range(n):

        now[dic[s[i]]] += 1

        while p[ind] == i+1:
            ind += 1

            for j in range(26):
                ans[j] += now[j]

    print (" ".join(map(str,ans)))
