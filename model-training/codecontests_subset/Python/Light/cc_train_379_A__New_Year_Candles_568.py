a, b = map(int, input().split())
sum,ost = 0,0

while a :
     sum+=a
     ost+=a%b
     a//=b
     a+=ost//b
     ost%=b

print (sum)
