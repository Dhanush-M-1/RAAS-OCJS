while True :
    n = int(input())
    
    if(n == 0) :
        break
    
    else :
        S = [len(input()) for i in range(n)]
        T = [5, 7, 5, 7, 7]
        ans = 0
        
        for i in range(n) :
            s = 0
            w = 0
            for j in range(i, n) :
                s += S[j]
                if(s == T[w]) :
                    s = 0
                    w += 1
                    if(w == 5) :
                        ans = i + 1
                        break
                    else :
                        pass
                elif(s > T[w]) :
                    break
                else :
                    pass
            if(ans != 0) :
                break
            else :
                pass
        print(ans)
        
