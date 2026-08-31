n = int(input())
s = input()
if s.count('I') == 1:
    print(1)
elif 'I' in s:
    print(0)
else:
    print(s.count('A'))