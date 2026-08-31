input()
first = list(map(int, input().split()))
second = list(map(int, input().split()))
third = list(map(int, input().split()))

first_int = [int(i) for i in first]
first_sum = sum(first_int)
second_int = [int(i) for i in second]
second_sum = sum(second_int)
third_int = [int(i) for i in third]
third_sum = sum(third_int)
print(first_sum - second_sum)
print(second_sum - third_sum)
