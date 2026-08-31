s = input()
n = int(input())
a = []
for i in range(n):
    a.append(input())

flag = 0    
for i in range(n):
    for j in range(n):
        if s in (a[i]+a[j]):
            flag = 1
            break

if flag == 1:
    print("YES")
else:
    print("NO")