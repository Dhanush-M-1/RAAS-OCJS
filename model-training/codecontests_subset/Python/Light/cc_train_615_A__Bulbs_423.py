__author__ = 'suvasish'

n, m = map(int, input().split())
m_lst = [0] * m
# print(m_lst)
# print('------')
for l in range(0, n):
    inp = list(map(int, input().split()))
    for b in range(1, len(inp)):
        if m_lst[inp[b]-1] == 0:
            m_lst[inp[b]-1] = 1

print("NO") if m_lst.count(0) >= 1 else print("YES")
