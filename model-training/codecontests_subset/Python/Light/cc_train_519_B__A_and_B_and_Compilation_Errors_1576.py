a = int(input())
n = [int(i) for i in (input().split())]
n_1 = [int(i) for i in (input().split())]
n_2 = [int(i) for i in (input().split())]
n.sort()
n_1.sort()
n_2.sort()
n_1.append(-1)
n_2.append(-1)
n_2.append(-1)
b = []
for i in range(len(n)):
    if n[i] != n_1[i]:
        b.append(n[i])
        break


for i in range(len(n_1)):
    if n_1[i] != n_2[i]:
        b.append(n_1[i])
        break

print(*b, sep='\n')