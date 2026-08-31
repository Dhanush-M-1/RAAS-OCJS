input()
s = input()
x = s.count('I')

print(0 if x>1 else s.count('A') if x<1 else 1)