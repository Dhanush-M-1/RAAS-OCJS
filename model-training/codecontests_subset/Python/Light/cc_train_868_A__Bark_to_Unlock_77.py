password = input()
n = int(input())
first_letter_found = second_letter_found = 0
result = 'NO'
for i in range(n):
    word = input()
    if word==password:
        result = 'YES'
    elif result=='NO':
        if word[1]==password[0]:
            first_letter_found = 1
        if word[0]==password[1]:
            second_letter_found = 1

if result=='NO' and first_letter_found==1 and second_letter_found==1:
    result='YES'
    
print(result)