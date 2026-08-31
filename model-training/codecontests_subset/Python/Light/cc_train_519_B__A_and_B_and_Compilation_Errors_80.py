from collections import Counter

n = int(input())
first_errors = Counter(map(int, input().split()))
# print(first_errors)
second_errors = Counter(map(int, input().split()))
# print(second_errors)
third_errors = Counter(map(int, input().split()))
# print(third_errors)

first_correction = first_errors - second_errors
# print(first_correction)
second_correction = second_errors - third_errors
# print(second_correction)
print(first_correction.most_common()[0][0])
print(second_correction.most_common()[0][0])
