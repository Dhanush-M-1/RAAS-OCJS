import sys
input = sys.stdin.readline
 
t = int(input())
 
for _ in range(t):
    s = list(input())[:-1]
    ans = 0
    i = 0

    while True:
        if i >= len(s):
            break
    
        curr = s[i]
        if curr == '-':
            i += 1
            continue
        if i+1 < len(s) and s[i+1] == curr:
            ans += 1
            s[i+1] = '-'
        if i+2 < len(s) and s[i+2] == curr:
            ans += 1
            s[i+2] = '-'

        else:
            i += 1
        if i >= len(s):
            break
    
    print(ans)