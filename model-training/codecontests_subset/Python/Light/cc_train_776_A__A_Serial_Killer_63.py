a , b = input().split()
n = int(input())
print(a , b)
for i in range(n):
    x , y = input().split()
    if(x == a):
        a = y
    else:
        b = y
    print(a , b)