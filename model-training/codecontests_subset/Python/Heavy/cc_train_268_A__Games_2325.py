
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

home_uniforms = defaultdict(int)
visiting_uniforms = defaultdict(int)

teams_count = int(input())


for i in range(teams_count):
    home_uniform, visiting_uniform = input().split()
    home_uniforms[home_uniform] += 1
    visiting_uniforms[visiting_uniform] += 1

res = 0
for uniform_color, color_cnt in home_uniforms.items():
    teams_with_same_uniform_color = visiting_uniforms.get(uniform_color)
    if teams_with_same_uniform_color:
        res += teams_with_same_uniform_color * color_cnt

print(res)
