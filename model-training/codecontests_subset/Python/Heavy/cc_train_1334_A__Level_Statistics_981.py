def solution():
    t = int(input())
    for _ in range(t):
        n = int(input())
        p = []
        c = []
        for _ in range(n):
            pi,ci = map(int,input().split())
            p.append(pi)
            c.append(ci)
        if p[0] < c[0]:
            print("NO")
            continue
        was_error = False
        for i in range(1,n):
            if p[i] < p[i-1] or c[i] < c[i-1]:
                was_error = True
                print("NO")
                break
            if p[i] == p[i-1]:
                if not c[i] == c[i]:
                    was_error = True
                    print("NO")
                    break
            if p[i] - p[i-1] < c[i] - c[i-1]:
                was_error = True
                print("NO")
                break
        if not was_error:
            print("YES")
solution()