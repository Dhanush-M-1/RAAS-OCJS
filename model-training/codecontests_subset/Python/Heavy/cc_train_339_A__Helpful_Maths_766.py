s = input()
x = s.count("1")
y = s.count("2")
z = s.count("3")
a = ""
b = ""
c = ""
for i in range(x):
    a = a + "1+"
for i in range(y):
    b = b + "2+"
for i in range (z):
    c = c + "3+"
s = a + b + c
print(s[0:len(s) - 1])
# e7na bntb3 kol el string ma 3da a5er 7rf
# 34an e7na bn7ot 7rf zyada fel a5er '+'
# 2 hamza 'ء'
# 3 3en 'ع'
# 4 sheen 'ش'
# 5 kha 'خ'
# 7 7a 'ح'
# 8 or 3' 3'een 'غ'
# if we print (a + b + c) we note that
# there is an extra '+' at the end, so
# we don't print the last character