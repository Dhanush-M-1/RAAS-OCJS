# 438
# A. Bark to Unlock

password = input()
n = int(input())

k_list = [input() for i in range(n)]

# contain it as 2letters

if password in k_list:
    print("YES")
else:
    front = password[0]
    end = password[1]

    frontF = endF = False

    for letters in k_list:
        if letters[1] == front:
            frontF = True
        if letters[0] == end:
            endF = True

    if frontF and endF:
        print("YES")
    else:
        print("NO")
