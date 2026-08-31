t = int(input())
for q in range(t):
    ans = [0] * 26
    n,m = map(int, input().split())
    s = input()
    p = list(map(int, input().split()))
    p.sort(reverse=True)
    cnt = 0
    si = n - 1
    for elem in p:
        while si > elem-1:
            ind = ord(s[si]) - ord('a')
            ans[ind] += cnt
            si-=1
        cnt+=1
        # last = elem
    while si >=0:
        ind = ord(s[si]) - ord('a')
        ans[ind] += cnt
        si -= 1
    for c in s:
        ans[ord(c) - ord("a")]+=1
    print(*ans)