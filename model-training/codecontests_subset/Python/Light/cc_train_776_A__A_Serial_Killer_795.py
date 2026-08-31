try:
    def solve():
        s = input().split()
        n = int(input())
        print(s[0], s[1])
        for i in range(n):
            y = input().split()
            s[s.index(y[0])] = y[1]
            print(s[0], s[1])


    t = 1
    for _ in range(t):
        solve()
except:
    pass
