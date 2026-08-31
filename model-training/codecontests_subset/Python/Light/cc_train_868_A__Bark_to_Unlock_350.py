pas = input()
n = int(input())
x = []
for i in range(n):
    s = input()
    x.append(s)
cnt1 = 0
cnt2= 0
a = pas[0]
b = pas[1]
for i in range(n):
    if x[i][1] == a:
        cnt1+=1
    if x[i][0] == b:
        cnt2+=1

if pas in x:
    print("YES")
elif cnt1>0 and cnt2>0:
    print("YES")
else:
    print("NO")

