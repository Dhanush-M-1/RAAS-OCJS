password = input()
n = int(input())

dictnry = []
for i in range(n):
    dictnry.append(input())

first_letters = []
second_letters = []

for i in dictnry:
    first_letters.append(i[0])
    second_letters.append(i[1])

first_letters = str(first_letters)
second_letters = str(second_letters)

first_search = first_letters.find(password[1]) >= 0
second_search = second_letters.find(password[0]) >= 0

if (first_search and second_search) or (dictnry.count(password) == 1):
    print('YES')
else:
    print('NO')
