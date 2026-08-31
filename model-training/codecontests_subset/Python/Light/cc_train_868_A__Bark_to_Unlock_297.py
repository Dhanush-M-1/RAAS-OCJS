word = input()
char1 = word[0]
char2 = word[1]
n = int(input())
list1 = []
flag1 = False
flag2 = False
for x in range(n):
    new = input()
    list1.append(new)
    if new.endswith(char1):
        flag1 = True
    if new.startswith(char2):
        flag2 = True
    if new==word:
        flag1 = True
        flag2 = True
if flag1 and flag2:
    print("YES")
else:
    print("NO")
