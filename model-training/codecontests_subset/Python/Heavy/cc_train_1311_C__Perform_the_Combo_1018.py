t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    s = input()
    p = [int(x) for x in input().split()]
    a = [[0] for x in range(26)]
    a[ord(s[0])-97][0] = 1
    for i in range(1, n):
        temp = ord(s[i])-97
        for j in range(26):
            a[j].append(a[j][i-1])
            if j==temp:
                a[j][i] = a[j][i-1]+1
    ans = [0]*26
    p.append(n)
    for x in p:
        for i in range(26):
            ans[i] += a[i][x-1]
    for x in ans:
        print(x, end = " ")
    print()
