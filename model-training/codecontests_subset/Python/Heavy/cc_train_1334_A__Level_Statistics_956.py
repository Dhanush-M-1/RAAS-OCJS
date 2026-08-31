def solve(stats,ans):
    p,c = 0,0
    
    for i in range(len(stats)):
        curr_p,curr_c = stats[i][0],stats[i][1]
        if curr_c > curr_p:
            ans.append('NO')
            return
        
        if curr_p >= p:
            diff = curr_p-p
            if curr_c < c:
                ans.append('NO')
                return
            if curr_c-c > diff:
                ans.append('NO')
                return

        else:
            ans.append('NO')
            return

        p,c = curr_p,curr_c

    ans.append('YES')
            

def main():
    t = int(input())
    ans = []
    for i in range(t):
        n = int(input())
        stats = []
        for j in range(n):
            p,c = map(int,input().split())
            stats.append((p,c))

        solve(stats,ans)

    for i in ans:
        print(i)


main()
