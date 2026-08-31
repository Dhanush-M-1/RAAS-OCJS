import math

t = int(input())
abcd = []
for i in range(t):
    abcd.append(list(map(int, input().split())))

for i in range(t):
    if abcd[i][0] < abcd[i][1]:
        print("No")
    elif abcd[i][1] > abcd[i][3]:
        print("No")
    elif abcd[i][3] % abcd[i][1] == 0:
        if abcd[i][0] % abcd[i][1] > abcd[i][2]:
            print("No")
        else:
            print("Yes")
    else:
        big, small = abcd[i][1], abcd[i][3]
        while big % small:
            big, small = small, big % small
        gcd = small
        if abcd[i][1] - gcd <= abcd[i][2]:
            print("Yes")
        else:
            print("No")