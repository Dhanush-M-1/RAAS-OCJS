n = int(input())
s = input()
if n<11: print(0)
elif '8' not in s: print(0)
else:
    x = s.count('8')
    y = len(s)//11
    print(min(x,y))