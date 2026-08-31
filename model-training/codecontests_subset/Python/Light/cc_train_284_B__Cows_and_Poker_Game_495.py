n = int(input())
s = input()
d = {"A": 0, "I": 0, "F": 0}
for i in s:
    if i == "A":
        d[i] = d[i] + 1
    if i == "I":
        d[i] = d[i] + 1
    if i == "F":
        d[i] = d[i] + 1
if d["I"] == 0:
    print(d["A"])
elif d["I"] == 1:
    print(1)
else:
    print(0)
