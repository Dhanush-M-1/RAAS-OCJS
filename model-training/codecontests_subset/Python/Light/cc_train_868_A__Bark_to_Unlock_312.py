pw = input()
n = int(input())

match1, match2 = False, False

for i in range(n):
    word = input()
    if pw == word:
        print("YES")
        exit()
    else:
        if pw[0] == word[1]:
            match1 = True
        if pw[1] == word[0]:
            match2 = True
if match1 and match2:
    print("YES")
else:
    print("NO")
            
