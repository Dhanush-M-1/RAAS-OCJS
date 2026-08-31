from sys import exit
s = input()
n = int(input())
v = []
for i in range(n):
    v.append(input())
for i in range(n):
    for j in range(n):
        if (v[i] + v[j]).find(s) != -1:
            print("YES")
            exit(0)
print("NO")