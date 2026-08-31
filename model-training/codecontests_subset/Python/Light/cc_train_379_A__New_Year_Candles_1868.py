x = input()
x,y = x.split()
x,y = int(x),int(y)

ans = x
while(x>=y):
    ans = ans + x//y
    x = x%y + x//y

print (int(ans))
