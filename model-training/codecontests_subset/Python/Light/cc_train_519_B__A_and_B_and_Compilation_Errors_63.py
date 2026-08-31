n = int(input())
s = []

for i in (0,1,2):
    l=list(map(int,input().split()))
    s.append(l)
    s[i]=sorted(s[i])
    s[i].append(0)

for i in (0,1):
    for j in range(0,len(s[i+1])):
        if s[i][j] != s[i+1][j]:
            print(s[i][j])
            break
