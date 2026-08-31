n = int(input())
str = input()
if n % 11 == 0 :
    if str.count("8") > n // 11:
        print(n // 11)
    else:
        print(str.count("8"))
else:
    if str.count("8") > n // 11:
        print(n // 11)
    else:
        print(str.count("8"))
