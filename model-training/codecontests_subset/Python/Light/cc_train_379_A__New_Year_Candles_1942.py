a, b = list(map(int, input().split()))
hours = a
while True:
    c = a//b
    a = c + (a%b)
    hours+=c
    if a<b: break
print(hours)