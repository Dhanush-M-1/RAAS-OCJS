# import sys 
# sys.stdin = open('input.txt', 'r')  
# sys.stdout = open('output.txt', 'w')

def solve(s, p):
    n, m = len(s), len(p)
    cnt = [0]*n 
    for i in range(m):
        cnt[p[i]-1] += 1 
    
    cnt[-1] += 1
    for i in range(n-2,-1,-1):
        cnt[i] += cnt[i+1]

    ans = [0]*26
    for i in range(n):
        ans[ord(s[i])-ord('a')] += cnt[i]
    
    print(*ans, end=" ")
    print()
    return 

# s = "abca"
# p = [1, 3]
# print(solve(s, p))
t = int(input())
for i in range(t):
    n, m = [int(x) for x in input().split()]
    s = input()
    p = [int(x) for x in input().split()]
    solve(s, p)
