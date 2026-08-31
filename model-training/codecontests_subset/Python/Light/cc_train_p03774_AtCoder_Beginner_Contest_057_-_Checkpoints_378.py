# coding: utf-8
N, M = map(int, input().split())
students = [list(map(int, input().split())) for _ in range(N)]
c_points = [list(map(int, input().split())) for _ in range(M)]

for a,b in students:
    m_dis = [abs(a-c) + abs(b-d) for c,d in c_points]
    print(m_dis.index(min(m_dis)) + 1)
