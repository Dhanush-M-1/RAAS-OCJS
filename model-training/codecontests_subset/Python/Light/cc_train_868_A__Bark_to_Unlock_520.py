password = input()
n = int(input())
strings = []
for _ in range(n):
    strings.append(input())
ans = "NO"
for i in range(n):
    for j in range(i,n):
        if (strings[i]+strings[j]).find(password) != -1:
            ans = "YES"
        if (strings[j]+strings[i]).find(password) != -1:
            ans = "YES"
print(ans)