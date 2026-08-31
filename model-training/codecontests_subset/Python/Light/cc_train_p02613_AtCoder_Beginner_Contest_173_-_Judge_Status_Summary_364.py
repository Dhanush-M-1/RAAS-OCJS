n = int(input())
s = {"AC":0, "WA":0, "TLE":0, "RE":0}
for i in range(n):
    s[input()]+=1
for i, j in s.items():
    print(f"{i} x {j}")
