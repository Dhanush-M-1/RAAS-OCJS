n = int(input())

l = [ [int(s) for s in input().split(" ")] for i in range(3) ]

print(sum(l[0]) - sum(l[1]))
print(sum(l[1]) - sum(l[2]))