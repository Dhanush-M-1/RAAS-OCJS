n = int(input())

i1 = [int(e) for e in input().split()]
i2 = [int(el) for el in input().split()]
i3 = [int(ele) for ele in input().split()]

e = [sum(i1),sum(i2),sum(i3)]
print(e[0] - e[1])
print(e[1] - e[2])




