answ, b = map(int, input().split())
p = answ 
while (p // b > 0):
    answ += p//b
    p = p//b + p %b

print(answ)
