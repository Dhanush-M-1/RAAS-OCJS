Q = int(input())
src = [int(input()) for i in range(Q)]
for n in src:
    ans = 0
    _n = n
    st = set()
    while _n >= 10:
        if _n in st:
            print(-1)
            break
        st.add(_n)
        s = str(_n)
        next = 0
        for i in range(1,len(s)):
            next = max(next, int(s[:i]) * int(s[i:]))
        _n = next
        ans += 1
    else:
        print(ans)