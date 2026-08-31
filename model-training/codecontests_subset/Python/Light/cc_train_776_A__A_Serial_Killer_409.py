# Codeforces 776A

v1, v2 = input().split(' ')
print(v1, v2)
n = int(input())
for i in range(n):
    dead, new = input().split(' ')
    if dead == v1:
        v1 = new
    else:
        v2 = new
    print(v1, v2)