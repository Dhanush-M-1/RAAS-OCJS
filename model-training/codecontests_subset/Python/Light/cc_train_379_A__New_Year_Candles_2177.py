a,b = map(int,input().split())
summ = a
n = a
while (n>=b):
    summ += (n//b)
    n = (n//b) + (n%b)

print(summ)