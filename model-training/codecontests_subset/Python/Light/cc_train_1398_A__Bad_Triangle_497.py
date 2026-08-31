def sol(inp, n):
    sm = []
    ind = []
    po = 0
    for i in range(n):
        sm.append(inp[i])
        ind.append(i+1)
        po += 1
        if po==2 and sum(sm) <= inp[-1]:
            print(*ind, end=" ")
            print(n)
            return
        if sum(sm)>inp[-1]:
            sm = []
            ind = []
            po = 0
        continue
    print(-1)
    return

    
if __name__ == '__main__':
    for _ in range(int(input())):
        n = int(input())
        inp = list(map(int, input().split()))
        sol(inp, n)
                
            