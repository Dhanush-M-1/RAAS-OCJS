# https://codeforces.com/problemset/problem/519/B
# data structures, sorting, implementation
# Gde Anantha Priharsena
# 21 Juli 2020
# Approach : 
# difficulty : 1100

def sumArray(arr) :
    n = len(arr)
    count = 0
    for i in range(len(arr)) :
        count += arr[i]
    return count


n = int(input())
first_error = list(map(int, input().split()))
count_first = sumArray(first_error)
second_error = list(map(int, input().split()))
count_second = sumArray(second_error)
third_error = list(map(int, input().split()))
count_third = sumArray(third_error)

print(count_first-count_second)
print(count_second-count_third)