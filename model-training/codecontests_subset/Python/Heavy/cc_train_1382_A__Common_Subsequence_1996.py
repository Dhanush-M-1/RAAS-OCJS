for _ in range(int(input())):

    n, m = map(int, input().strip().split())

    N = list(map(int, input().strip().split()))

    M = list(map(int, input().strip().split()))

    s1 = set(N)
    s2 = set(M)
    mins = -1
    n_d = {x : 0 for x in s1}
    m_d = {y : 0 for y in s2}

    for f in n_d:

        n_d[f] += 1

    for g in m_d:

        m_d[g] += 1 
    count = 0
    for key in n_d.keys(): 

        if key in m_d: 
            print("YES")
            print("1",key)
            count = 1
            break
    
    if count == 0:
        print("NO")