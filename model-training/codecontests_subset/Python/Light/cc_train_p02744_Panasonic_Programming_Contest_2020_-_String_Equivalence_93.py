def dfs(s, mx):
    if len(s) == N:
        print(s)
        return
    for c in range(ord("a"), mx + 1):
        dfs(s + chr(c), mx + 1 if c == mx else mx)

if __name__ == "__main__":
    N = int(input())
    dfs("", ord("a"))