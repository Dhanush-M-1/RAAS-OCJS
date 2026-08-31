n = int(input())
num = input()
if n%11<=11 and '8' in num:
    if num.count('8')<=n//11:
        print(num.count('8'))
    else:
        print(n//11)
else:
    print(0)
