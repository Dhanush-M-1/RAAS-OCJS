
num = int(input())

first_run = sum([int(i) for i in input().split(' ')])

second_run = sum([int(i) for i in input().split(' ')])
print(first_run - second_run)

tired_run = sum([int(i) for i in input().split(' ')])
print(second_run - tired_run)
