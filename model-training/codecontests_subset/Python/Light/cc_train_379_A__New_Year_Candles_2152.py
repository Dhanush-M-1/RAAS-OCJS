a, b = list(map(int, input().split()))
sum = a
while True:
    c = a//b
    a = c + (a%b)
    sum+=c
    if a<b: break
print(sum)