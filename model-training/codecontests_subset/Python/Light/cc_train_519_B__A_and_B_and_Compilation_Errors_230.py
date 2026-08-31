from collections import Counter

_ = input()
first_line = Counter(input().split())
second_line = Counter(input().split())
third_line = Counter(input().split())
first_delta = iter(first_line - second_line)
second_delta = iter(second_line - third_line)
print(next(first_delta))
print(next(second_delta))
