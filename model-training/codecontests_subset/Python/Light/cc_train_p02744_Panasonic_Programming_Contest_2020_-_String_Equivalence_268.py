n = int(input())
alph = 'abcdefghij'


def dfs(s, i):
    if len(s) == n:
        return s
    return "\n".join([dfs(s + c, i)for c in alph[:i]] +\
                     [dfs(s + alph[i], i + 1)])


print(dfs("a", 1))
