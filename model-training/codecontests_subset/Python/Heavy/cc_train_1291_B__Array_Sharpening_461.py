t = int(input())
for j in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    i = 0
    while (i != len(a) and a[i] >= i):
        i+=1
    if i == len(a):
        print("Yes")
    else:
        i2 = i
        i = len(a) - i - 1
        if i >= a[i2 - 1]:
            print("No")
        else:
            while(i2 != len(a) and a[i2] >= i and i >= 0):
                i-=1
                i2 += 1
            if (i2 == len(a)):
                print("Yes")
            else:
                print("No")