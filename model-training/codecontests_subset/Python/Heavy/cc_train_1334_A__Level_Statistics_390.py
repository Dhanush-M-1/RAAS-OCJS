from sys import stdin,stdout
t=int(stdin.readline().strip())
for casos in range(t):
    n=int(stdin.readline().strip())
    s=[]
    for i in range(n):
        s.append(list(map(int,stdin.readline().strip().split())))
    flag=True
    for i in range(1,n):
        if s[i][0]<s[i-1][0] or s[i][1]<s[i-1][1] or (s[i][0]-s[i-1][0])<(s[i][1]-s[i-1][1]):
            flag=False
    for i in range(n):
        if s[i][0]<s[i][1]:
            flag=False
    if flag:
        print("YES")
    else:
        print("NO")

