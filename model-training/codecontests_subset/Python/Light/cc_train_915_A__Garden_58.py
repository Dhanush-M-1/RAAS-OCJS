x, y = [int(i) for i in input().split()]
z = [int(i) for i in input().split()]
z.sort()
for i in z[::-1]:
    if y % i == 0:
        print(y//i)
        break
