# https://codeforces.com/problemset/problem/379/A

a,b = list(map(int, input().split()))

hours = a
mark = 0

while a>=b:
    mark = a%b
    a = (a-mark)//b
    hours += a
    a += mark

print(hours)