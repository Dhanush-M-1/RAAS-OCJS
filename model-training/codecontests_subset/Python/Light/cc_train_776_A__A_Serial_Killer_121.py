name = []
name.append(input().split())
n = int(input())
for i in range (n):
    p1, p2 = input().split()
    if name[i][0] == p1:
        name.append([p2, name[i][1]])
    else:
        name.append([name[i][0], p2])
for n in name:
    print(n[0], n[1])
