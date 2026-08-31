import sys
read = sys.stdin.buffer.read
readline = sys.stdin.buffer.readline
readlines = sys.stdin.buffer.readlines
t = int(readline())

for _ in range(t):
    n,m = map(int,readline().split())
    s = readline().rstrip().decode('utf-8')
    p = list(map(int,readline().split()))
    lst = [0]*n
    for i in p:
        lst[i-1]+=1
    lst[-1] += 1
    for i in range(n-1,0,-1):
        lst[i-1] += lst[i]
    
    ans = [0]*26
    kijun = ord("a")
    for i in range(n):
        ans[ord(s[i])-kijun] += lst[i]

    print(*ans)
