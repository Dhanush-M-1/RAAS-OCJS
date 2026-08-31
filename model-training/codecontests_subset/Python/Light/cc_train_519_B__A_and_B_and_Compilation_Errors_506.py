x = input()
x = [int(x1) for x1 in input().split()]
y = [int(y1) for y1 in input().split()]
z = [int(z1) for z1 in input().split()]
data = [sum(x)-sum(y),sum(y)-sum(z)]
r = str(data[0]) + "\n" + str(data[1])
print(r)