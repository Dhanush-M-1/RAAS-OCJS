import sys
my_file = sys.stdin
#my_file = open("input.txt", "r")
line = [int(i) for i in my_file.readline().split()]
n, x, y = line[0], line[1], line[2]
res = 0
while x < n*y/100:
    x += 1
    res += 1
print(res)