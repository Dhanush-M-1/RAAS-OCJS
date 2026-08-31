#http://codeforces.com/problemset/problem/893/A
#solved

n = int(input())
array = [int(input()) for _ in range(n)]

Alex = True
Bob = True
Carl = False

for i in array:
    if i == 1 and Alex is False:
        print("NO")
        quit()

    elif i == 2 and Bob is False:
        print("NO")
        quit()

    elif i == 3 and Carl is False:
        print("NO")
        quit()

    else:
        if i == 1 and Carl == False:
            Carl = True
            Bob = False

        elif i == 1 and Bob == False:
            Carl = False
            Bob = True

        if i == 2 and Carl == False:
            Carl = True
            Alex = False

        elif i == 2 and Alex == False:
            Carl = False
            Alex = True

        if i == 3 and Alex == False:
            Alex = True
            Bob = False

        elif i == 3 and Bob == False:
            Alex = False
            Bob = True

print("YES")