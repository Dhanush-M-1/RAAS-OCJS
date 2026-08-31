if __name__=='__main__':
    t = int(input())
    for _ in range(t):
        n = int(input())
        flag=False
        l = list()
        l.append((0,0))
        for i in range(n):
            p, c = map(int, input().split(' '))
            l.append((p,c))
        p_old, c_old = l[0]
        for i in range(1, n+1):
            p, c = l[i]
            c_diff = c-c_old
            p_diff = p-p_old
            if ((c_diff)>(p_diff)):
                flag = True
                break
            if (c_diff<0 or p_diff<0):
                flag = True
                break
            p_old, c_old = p, c

        if flag:
            print("NO")
        else:
            print("YES")

