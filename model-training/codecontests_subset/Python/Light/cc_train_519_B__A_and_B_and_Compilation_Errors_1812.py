n = int(input())

first = list(map(int, input().split()))
second = list(map(int, input().split()))
third = list(map(int, input().split()))

sum_f = sum(first)
sum_s = sum(second)
sum_t = sum(third)

print(sum_f - sum_s)
print(sum_s - sum_t)
#This is it