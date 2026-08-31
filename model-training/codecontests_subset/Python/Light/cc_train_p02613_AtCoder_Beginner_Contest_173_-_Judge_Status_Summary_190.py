n=int(input())
s_list=[input() for i in range(n)]

v=["AC", "WA", "TLE", "RE"]
for i in v:
    print(f"{i} x {s_list.count(i)}")
