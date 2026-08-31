import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    s = input()[:-1]
    p = list(map(int, input().split()))+[n]
    acc = [[0] for _ in range(26)]
    
    for i in range(n):
        for j in range(26):
            if ord(s[i])-ord('a')==j:
                acc[j].append(acc[j][-1]+1)
            else:
                acc[j].append(acc[j][-1])
    
    ans = [0]*26
    
    for i in range(26):
        for pi in p:
            ans[i] += acc[i][pi]
        
    print(*ans)