n = int(input())
s = input()

if n<11:
    print(0)
else:
    temp = n/11
    if s.count('8') == temp or s.count('8')<temp:
        print(s.count('8'))
    else:
        print(int(temp))