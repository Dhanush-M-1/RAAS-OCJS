
# def gcd(lft, rght):
#     if lft < rght:
#         rght, lft = lft, rght
#     if rght == 0:
#         return lft
#     return gcd(rght, lft % rght)
#
#
# def lcm(lft, rght):
#     return (lft * rght) / gcd(lft, rght)
from collections import defaultdict

inputs_cnt = int(input())

tree = defaultdict(set)

for input_index in range(inputs_cnt):
    a_len, b_len = map(int, input().split())
    a = set(input().split())
    b = set(input().split())

    intersection = list(a & b)
    if intersection:
        print('YES')
        print(1, intersection[0])
    else:
        print('NO')
