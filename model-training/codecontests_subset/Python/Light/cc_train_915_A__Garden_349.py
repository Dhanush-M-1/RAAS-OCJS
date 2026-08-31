a = [int(i) for i in input().split()]
b = sorted([int(i) for i in input().split()])

for i in range(a[0]):
    if a[1]%b[-1]==0:
        print(a[1]//b[-1])
        break
    else:
        b = b[:-1]