import sys
def alele(): return list(map(int, sys.stdin.readline().strip().split()))
def ilele(): return map(int, sys.stdin.readline().strip().split())
def input(): return sys.stdin.readline().strip()


for _ in range(int(input())):
    n,m = map(int,input().split(" "))
    S = input()
    A = list(map(int,input().split(" ")))
    Ans = {}
    for i in range(97,123):
        Ans[chr(i)] = 0
    mark = Ans.copy()
    #print(mark)
    dp = {}
    for i in range(len(S)):
        mark[S[i]] += 1
        dp[i+1] = mark.copy()
    A.append(n)
    for i in A:
        for j,k in dp[i].items():
            Ans[j] += k
    #print(Ans)
    for i,j in sorted(Ans.items()):
        print(j,end = " ")
    print()
        
    
        