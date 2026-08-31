a,b = map(int,input().split())
#1 1 1 1...b 1 1 1 1...b 1 1 1...b 1 1 1....b ......(a<b)1.....(a)
#no of new candles = a//b
#new total = a%b + no of new candles
count = 0
while (a>0):
    if a>=b:
        count += (a//b)*b
        a = a//b + a%b
    else:
        count+=a
        a=0
print(count)