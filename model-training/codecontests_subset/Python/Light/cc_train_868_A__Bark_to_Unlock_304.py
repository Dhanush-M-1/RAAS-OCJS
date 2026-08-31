pas = input('')

n = int(input(''))

list = []

for i in range (n):
    list.append(input(''))
    
bool1 , bool2 = False , False

for word in list:
    if word[1].lower() == pas[0].lower():
        bool1 = True
    if word[0].lower() == pas[1].lower():
        bool2 = True
    if word.lower() == pas.lower() :
        bool1 , bool2 = True , True

if bool1 and bool2 :
    print('YES')
else :
    print('NO')