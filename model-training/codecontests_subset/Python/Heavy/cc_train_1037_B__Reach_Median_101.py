def sol():
    N, S = [int(x) for x in input().split(" ")]
    a = [int(x) for x in input().split(" ")]

    m_index = N//2

    a = sorted(a)

    if N == 1:
        print(abs(a[0] - S))
        return

    # binary search for median?

    index = 0

    if a[0] >= S:
        index = 0

    elif a[-1] <= S:
        index = N - 1

    else:
        for i in range(1, len(a)-1):

            if i < m_index:
                if a[i-1] <= S and S <= a[i+1]:
                    index = i + 1
                    break

            elif i == m_index and a[i-1] <= S and S <= a[i+1]:
                index = i
                break

            elif a[i-1] <= S and S <= a[i+1]: # i > m_index
                index = i
                break

    cost = 0
    if index <= m_index:
        for i in range(index, m_index + 1):
            cost += abs(a[i] - S)

    else:
        for i in range(m_index, index + 1):
            cost += abs(a[i] - S)

    print(cost)

#for t in range(int(input())):
sol()
