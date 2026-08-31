n = int(input())
a = str(input())
count = 0

if "I" in a:
    if a.count("I") > 1:
        print(0)

    else:
        print(1)

else:
    for i in range(0, n):
        if a[i] == "A":
            count += 1

    print(count)