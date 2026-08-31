# http://codeforces.com/problemset/problem/519/B
n = int(input())

first = sum([int(x) for x in input().split()])
second = sum([int(x) for x in input().split()])
print(first-second)
third = sum([int(x) for x in input().split()])
print(second-third)