N = int(input())
eight_amount = input().count("8")
if eight_amount == 0:
    print(0)
elif N // 11 >= eight_amount:
    print(eight_amount)
else:
    print(N // 11)