


if __name__ == "__main__":
    for _ in range(int(input())):
        n = int(input())
        p = [0] * n
        c = [0] * n
        for i in range(n):
            p[i], c[i] = list(map(int, input().split()))
        
        p_last = p[0]
        c_last = c[0]
        possible = p_last >= c_last

        for i in range(1, n):
            p_current = p[i]
            c_current = c[i]

            if c_current < c_last or p_current < p_last:
                possible = False
                break
            
            if c_current > p_current:
                possible = False
                break

            if c_current - c_last > p_current - p_last:
                possible = False
                break

            p_last, c_last = p_current, c_current
        
        if possible:
            print("YES")
        else:
            print("NO")