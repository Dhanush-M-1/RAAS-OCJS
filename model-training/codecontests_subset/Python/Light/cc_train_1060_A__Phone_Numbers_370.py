n = int(input())
s = input()
if '8' not in s or n<11:
    print(0)
else:
    if s.count('8')>=n//11:
        print(n//11)
    else:
        print(s.count('8'))