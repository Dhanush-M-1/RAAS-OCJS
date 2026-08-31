n=int(input())
s=input()
if '8' in s and n>=11:
    t=int(n/11)
    if t<=s.count('8'):
        print(int(n/11))
    else:
        print(s.count('8'))
else:
    print(0)
