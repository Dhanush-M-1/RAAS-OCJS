__author__ = 'Andrey'
n = int(input())
s = sum(map(int, input().split()))
s_1 = sum(map(int, input().split()))
s_2 = sum(map(int, input().split()))
print(s - s_1)
print(s_1 - s_2)