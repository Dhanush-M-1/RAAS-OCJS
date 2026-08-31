from collections import Counter

n = input()
f_dict = Counter(input().split())
s_dict = Counter(input().split())
t_dict = Counter(input().split())

for i in f_dict:
    if not i in s_dict or f_dict[i] > s_dict[i]:
        print(i)

for i in s_dict:
    if not i in t_dict or s_dict[i] > t_dict[i]:
        print(i)