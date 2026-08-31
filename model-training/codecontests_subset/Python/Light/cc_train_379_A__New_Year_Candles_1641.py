a, b = list(map(int, input().split()))

newa = a 
wentc = 0
result = 0

if b > a:
    print(a)

elif a == b:
    print(a + 1)

else:
    while (wentc + newa) >= b:
        wentc += newa
        result += newa
        newa = wentc // b 
        wentc -= newa * b 
    result += newa
    print(result)
        
