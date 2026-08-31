x = int(input())
n1 = [int(a) for a in input().split()]
n2 = [int(a) for a in input().split()]
n3 = [int(a) for a in input().split()]

sum_n1 = 0
sum_n2 = 0
sum_n3 = 0

for i in range(len(n1)):
    sum_n1 += n1[i]
for j in range(len(n2)):
    sum_n2 += n2[j]
for k in range(len(n3)):
    sum_n3 += n3[k]

print(sum_n1 - sum_n2)
print(sum_n2 - sum_n3)
