from sys import stdin,stdout
input = stdin.readline

def main():
    t = int(input())
    #t=1
    for z in range(t):
        #n = int(input())
        #n, k  = map(int,input().split())
        #ai = list(map(int,input().split()))
        input()
        k, n, m  = map(int,input().split())
        ai = list(map(int,input().split()))
        bi = list(map(int,input().split()))
        ans = []
        num = k
        ia,ib = 0,0
        for i in range(n+m):
            if ia < n and ai[ia] == 0:
                ans += [0]
                ia += 1
                num += 1
                continue
            if ib < m and bi[ib] == 0:
                ans += [0]
                ib += 1
                num+=1
                continue
            if  ia < n and ai[ia] <= num:
                ans += [ai[ia]]
                ia += 1
                continue
            if ib < m and bi[ib] <= num:
                ans += [bi[ib]]
                ib += 1
                continue
            ans = [-1]
            break
        print(*ans)
                
main()

