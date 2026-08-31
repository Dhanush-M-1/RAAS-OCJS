password = input()
count = int(input())

has_start = False
has_end = False

for i in range(count):
    word = input()
    if word == password:
        has_start = True
        has_end = True
    if word[1] == password[0]:
        has_start = True
    if word[0] == password[1]:
        has_end = True
        
print('YES' if has_start and has_end else 'NO')