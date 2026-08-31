a,b = map(int, input().split())

result = 0
left = a*b

while left>=b:
    result += left//b
    left = left%b+left//b
print(result)