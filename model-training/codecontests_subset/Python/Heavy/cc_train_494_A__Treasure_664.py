s = input()
c = s.count('#')
mylist = []
result = s.count('(') - s.count(')')
if result > 0:
    for i in range(c):
        if i == c - 1:
            mylist.append(result - c + 1)
        else:
            mylist.append(1)
else:
    mylist.append(-1)
s = list(s)
j = 1
for i in range(len(s)):
    if j < c:
        if s[i] == '#':
            s[i] = ')'
            j = j + 1
    else:
        if s[i] == '#':
            s[i] = ')' * mylist[len(mylist) - 1]          
s = ''.join(s)
a = 0
b = 0
for i in range(len(s)):
    if s[i] == '(':
        a = a + 1
    elif s[i] == ')':
        b = b + 1
        if a < b:
            mylist = [-1]
            break
for i in mylist:
    print(i)

        
