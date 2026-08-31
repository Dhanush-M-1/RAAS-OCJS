n = int(input())
rez = []
for i in range(n):
    tmp = input()
    tmp = list(map(int, input().split()))
    if tmp[0] + tmp[1] <= tmp[-1]:
        rez.append(str(1) + " " + str(2) + " " +str(len(tmp)))
    else:
        rez.append(-1)

for i in range(n):
    print(rez[i])
