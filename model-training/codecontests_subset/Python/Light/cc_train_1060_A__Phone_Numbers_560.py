"""https://codeforces.com/contest/1060/problem/A"""
n = int(input())
a = input()
eights = 0
for i in range(n):
    if a[i] == '8': eights+=1
elevens = n//11
print(min(eights,elevens))