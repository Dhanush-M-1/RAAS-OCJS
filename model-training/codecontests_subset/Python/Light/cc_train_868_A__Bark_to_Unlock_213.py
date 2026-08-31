s = input()
list = []
for i in range(int(input())):
    list.append(str(input()))
ans = "NO"
for i in list:
    for j in list:
        if (i[1] in s[0] and j[0] == s[1]) or s in list :
            ans = "YES"
print(ans)