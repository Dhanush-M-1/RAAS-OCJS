initial = input()
n = int(input())
for i in range(n):
    line = input().split()
    print(initial)
    initial = initial.split()
    initial[initial.index(line[0])]=line[1]
    initial = " ".join(initial)

print(initial)