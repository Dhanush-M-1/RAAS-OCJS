while True:
    n = int(input())
    if n == 0:
        break
    
    a = []
    for i in range(n):
        p = list(input())
        a.append(len(p))
    
    def solve(a):
        N = len(a)
        for i in range(N):
            judge = 0
            rest = 5
            for j in range(i,N):
                if judge == 0:
                    rest -= a[j]
                    if rest == 0:
                        judge = 1
                        rest = 7
                    elif rest < 0:
                        break
                elif judge == 1:
                    rest -= a[j]
                    if rest == 0:
                        judge = 2
                        rest = 5
                    if rest < 0:
                        break
                elif judge == 2:
                    rest -= a[j]
                    if rest == 0:
                        judge = 3
                        rest = 7
                    elif rest < 0:
                        break
                elif judge == 3:
                    rest -= a[j]
                    if rest == 0:
                        judge = 4
                        rest = 7
                    elif rest < 0:
                        break
                elif judge == 4:
                    rest -= a[j]
                    if rest == 0:
                        judge = 5
                        break
                    elif rest < 0:
                        break
            if judge == 5:
                return i+1
    print(solve(a))
