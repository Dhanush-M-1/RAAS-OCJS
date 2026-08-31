
x, y = input().split()
x = int(x)
y = int(y)
n= list(map(int, input().split()))
n.sort(reverse=True)
for i in n:
    if (y % i ==0):
        print(int(y/i))
        break
