number = input()
errors = sum(map(int, input().split()))
first_itr = sum(map(int, input().split()))
sec_itr = sum(map(int, input().split()))

print(errors - first_itr, first_itr - sec_itr)
