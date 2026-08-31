s = input()
words = []
n = int(input())
for _ in range(n):
    words.append(input())
f = 0
for i in range(n):
    st = words[i][1]
    for j in range(n):
        end = words[j][0]
        if st+end==s or s==words[j]:
            f = 1
            
if f:
    print("YES")
else:

    print("NO")