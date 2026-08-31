import sys

input = sys.stdin.readline
num_tests = int(input().strip())
numbers = [0] * num_tests
for i in range(num_tests):
    numbers[i] = int(input().strip())

for n in numbers:
    # look for number of steps
    aux = n
    num_steps = 0
    while aux != 1 and aux % 3 == 0:
        # is it odd? then multiply by 2
        if aux % 2 != 0:
            aux *= 2
            num_steps += 1
        aux = aux // 6
        num_steps += 1
    if aux == 1:
        print(num_steps)
    else:
        print(-1)