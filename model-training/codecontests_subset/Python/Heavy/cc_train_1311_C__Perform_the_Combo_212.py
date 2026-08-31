import sys, math

def input():
    return sys.stdin.readline()[:-1]

def main():
    q = int(input())
    for _ in range(q):
        n, m = map(int,input().split())
        s = input()
        p = list(map(int,input().split()))
        t = [[0 for k in range(26)] for l in range(n)]
        for k in range(n):
            t[k][ord(s[k])-97] += 1
        for k in range(1,n):
            for l in range(26):
                t[k][l] += t[k-1][l]
#        print(t)
        ans = [0 for k in range(26)]
        for k in range(m):
            for l in range(26):
                ans[l] += t[p[k]-1][l]
        for l in range(26):
            ans[l] += t[n-1][l]
        print(*ans)

if __name__ == '__main__':
    main()
