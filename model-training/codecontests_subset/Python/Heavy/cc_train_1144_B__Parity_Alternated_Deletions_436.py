n = int(input())
s = list(map(int, input().split()))
s.sort()
s.reverse()
z = s[0]
g = "None"
for i in range(1, n):
    if s[i] % 2 != z % 2:
        g = s[i]
        break
otv1 = [z]
otv2 = [g]
gr = [0]
if g != "None":
    gr1 = [s.index(g)]
else:
    gr1 = []
for j in range(n):
    for i in range(n):
        if s[i] % 2 != z % 2 and i not in gr:
            z = s[i]
            gr.append(i)
            otv1.append(s[i])
            break
    if str(otv2[0]) != "None":
        for i in range(n):
            if s[i] % 2 != g % 2 and i not in gr1:
                g = s[i]
                gr1.append(i)
                otv2.append(s[i])
                break
if str(otv2[0]) == "None":
    otv2 = []
po = []
popo = []
for i in range(n):
    if i not in gr:
        po.append(s[i])
for i in range(n):
    if i not in gr1:
        popo.append(s[i])
print(min(sum(po), sum(popo)))