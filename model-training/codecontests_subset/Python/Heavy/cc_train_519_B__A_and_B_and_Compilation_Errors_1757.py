n = int(input())
ls = [[],[],[]]
ls[0] = list(map(int,input().split()))
ls[1] = list(map(int,input().split()))
ls[2] = list(map(int,input().split()))
d_main = {}

for item in ls[0]:
    d_main[item] = 0
for item in ls[0]:
    d_main[item] += 1

d_copy1 = d_main.copy()
d_copy2 = d_main.copy()

for item in ls[1]:
    d_copy1[item] -= 1
for i in ls[0]:
    if d_copy1[i] > 0:
        print(i)
        d_copy2[i] -= 1
        break
for item in ls[2]:
    d_copy2[item] -= 1
for i in ls[0]:
    if d_copy2[i] > 0:
        print(i)
        break
