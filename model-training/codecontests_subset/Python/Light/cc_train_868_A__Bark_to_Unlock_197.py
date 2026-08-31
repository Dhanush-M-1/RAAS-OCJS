s = input()
n = int(input())
ss = []
for _ in range(n):
    ss.append(input())

found = False

for i in range(n):
    if ss[i] == s:
        found = True
    if found:
        break
    for j in range(n):
        if s == ss[i][1] + ss[j][0]:
            found = True
            break

if found:
    print("YES")
else:
    print("NO")
