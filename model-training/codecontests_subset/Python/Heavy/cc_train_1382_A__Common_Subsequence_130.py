t = int(input())
if t >= 1 and t <= 1000:
    n_list = []
    m_list = []
    for test in range(t):
        n, m = map(int, input().split())

        n_list = [int(i) for i in input().split()][:n]
        m_list = [int(i) for i in input().split()][:m]

        a_set = set(n_list)
        b_set = set(m_list)
        common = list(a_set.intersection(b_set))
        if len(common) > 0:
            print("YES")
            if len(common) > 1:
                print("1", common[0], sep=" ")
            else:
                print(len(common), *common, sep=" ")
        else:
            print("NO")
