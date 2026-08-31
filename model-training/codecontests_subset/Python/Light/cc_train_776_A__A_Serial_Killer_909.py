a,b = input().split()
print(a , b)
for i in range(int(input())):
    x , y = input().split()
    if a == x :
        a = y
    else :
        b = y
    print(a , b)