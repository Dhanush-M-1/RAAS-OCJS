a,b=map(int,input().split())
answ = a
while a>=b:
    answ+=a//b
    a=a//b+a%b
print(answ)