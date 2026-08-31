a,b = map(int, input().split())
sum = a
while(a>=b):
    sum = sum + a//b
    a = a//b + a%b
print(sum)