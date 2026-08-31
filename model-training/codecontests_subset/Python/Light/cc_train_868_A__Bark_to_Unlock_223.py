password = input()
tries = int(input())
sec = 0
first = 0
whole = ""
for i in range(tries):
    one = input()
    if password == one:
        print('Yes')
        exit(0)
    if password[0] == one[1]:
        first = first + 1
    if password[1] == one[0]:
        sec = sec + 1
if min(first, sec) != 0:
    print("Yes")
else:
    print("No")