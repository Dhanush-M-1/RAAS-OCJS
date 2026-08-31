# https://codeforces.com/problemset/problem/1060/A
n = int(input())
input = [int(x) for x in input().strip()]

num_8 = len(list(filter(lambda x: x == 8, input)))
max_numbers = n / 11
print(int(min(num_8, max_numbers)))