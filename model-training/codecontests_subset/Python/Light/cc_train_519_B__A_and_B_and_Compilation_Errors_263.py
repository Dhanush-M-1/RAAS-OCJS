_ = input()
initial = [int(i) for i in input().split()]
first = [int(i) for i in input().split()]
second = [int(i) for i in input().split()]


print(sum(initial)-sum(first))
print(sum(first)-sum(second))