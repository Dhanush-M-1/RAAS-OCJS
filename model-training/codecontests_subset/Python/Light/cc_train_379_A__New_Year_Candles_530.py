a, b = [int(i) for i in input().split()]
sum = a
while(1):
    c = int(a/b)
    a = c+int((a%b))
    sum = sum +c
    if a<b:
        break


print(sum)