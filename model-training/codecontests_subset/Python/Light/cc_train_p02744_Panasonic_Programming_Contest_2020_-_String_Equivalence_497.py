n = int(input())
a = ord('a')

def dfs(s, m):
    # print("dfs", s, chr(m))
    if len(s) == n:
        print(s)
    else:
        for i in range(m + 1 - a):
            dfs(s + chr(a + i), m + 1 if i == m - a else m)

dfs("", a)