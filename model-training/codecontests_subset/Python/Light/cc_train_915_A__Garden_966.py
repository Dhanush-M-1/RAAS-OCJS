n, k = [int(x) for x in input().split()]

a = [int(x) for x in input().split()]

a = filter(lambda x: k % x[1] == 0 and k >= x[1], enumerate(a))

print(int(k/max(a, key=lambda x: x[1])[1]))