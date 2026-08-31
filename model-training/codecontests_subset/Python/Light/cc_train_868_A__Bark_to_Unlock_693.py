a = input()
s = []
n = int(input())
for i in range(n):
    b = input()
    s.append(b)
c1 = 0
c2 = 0
for i in range(n):
    if s[i][0]  == a[-1]:
        c1+=1
    if s[i][-1] == a[0]:
        c2+=1
if a in s:
    print("YES")
elif c1>0 and c2>0:
    print("YES")
else:
    print("NO")