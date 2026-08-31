def solve() :
    I = input().split()
    S = I[0]
    C = I[1]
    ans = ""
    n = len(S)
    for i in range(0, n) :
        mini = 'z'
        for j in range(i + 1, n) :
            mini = min(mini, S[j])
        if(S[i] > mini) :
            pos = -1
            for j in range(i + 1, n) :
                if(S[j] == mini) :
                    pos = j
            for j in range(0, n) :
                if(j == i) :
                    ans += S[pos]
                elif(j == pos) :
                    ans += S[i]
                else :
                    ans += S[j]
            break
    if(ans == "") :
        ans = S
    if(ans < C) :
        print(ans)
    else :
        print("---")


t = int(input())
while(t > 0) :
    solve()
    t -= 1
