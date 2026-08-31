a,b = map(int,input().split())
total = a
burned = a

while burned >= b:
    total += burned//b
    burned = burned % b+burned//b

print(total)
