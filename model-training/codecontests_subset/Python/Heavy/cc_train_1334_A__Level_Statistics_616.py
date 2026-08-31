def solve(n, plays):
        prevC, prevP = 0,0
        for i in range(n):
                currP, currC = plays[i][0], plays[i][1]
                if currP < currC:
                        print("NO")
                        return
                if currP < prevP:
                        print("NO")
                        return
                if currC < prevC:
                        print("NO")
                        return
                if (currC-prevC) > (currP-prevP):
                        print("NO")
                        return
                prevP = currP
                prevC = currC
        print("YES")

t = int(input())
for test in range(t):
        n = int(input())
        plays = []
        for i in range(n):
                p,c = map(int, input().split())
                plays.append([p,c])

        solve(n, plays)
