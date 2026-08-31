def solve():
    
    n = int(input())
    l = [ [int(j) for j in input().split()] for i in range(n)]

    max_x = l[0][0]
    max_y = l[0][1]

    if l[0][0] < l[0][1]:
        print("NO")
        return

    for i in range(1, len(l)):

        dx = l[i][0] - l[i-1][0]
        dy = l[i][1] - l[i-1][1]

        if max_x > l[i][0] or max_y > l[i][1]:
            print("NO")
            return
        else:
            max_x = l[i][0]
            max_y = l[i][1]

        if dx < dy:
            print("NO")
            return

    print("YES")
        


T = int(input())

for i in range(T):
    solve()