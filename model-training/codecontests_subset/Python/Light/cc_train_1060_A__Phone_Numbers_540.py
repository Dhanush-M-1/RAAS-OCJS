n = int(input())
s = input()

if '8' in s and len(s) >= 11:
    count_8 = s.count('8')
    num = min(count_8,len(s)//11)
    print(num)
else:
    print(0)