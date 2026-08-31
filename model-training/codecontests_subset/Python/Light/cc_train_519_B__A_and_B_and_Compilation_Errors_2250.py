n = int(input())
line = [int(i) for i in input().split()]
for i in range(2):
    line1 = [int(i) for i in input().split()]
    line2 = line
    print(sum(line2)-sum(line1))
    line = line1