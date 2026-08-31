t = int(input())

for _ in range(t):
    s = input()
    ans = 0
    n = len(s)
    s += 'aaa'
    for i in range(n):
        if i == 0:
            continue
        if i == 1:
            if s[i] == s[i-1]:
                ans += 1
                for j in range(26):
                    if chr(j + ord('a')) != s[i-1] and chr(j + ord('a')) != s[i+1] and chr(j + ord('a')) != s[i+2]:
                        s = s[:i] + chr(j + ord('a')) + s[i+1:]
                        break
        else:
            if s[i] == s[i-1] or s[i] == s[i-2]:
                ans += 1
                for j in range(26):
                    if chr(j + ord('a')) != s[i-2] and chr(j + ord('a')) != s[i+1] and chr(j + ord('a')) != s[i + 2]:
                        s = s[:i] + chr(j + ord('a')) + s[i + 1:]
                        break
    print(ans)
