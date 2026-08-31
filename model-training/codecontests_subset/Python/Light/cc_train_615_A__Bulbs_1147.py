#n = number of buttons
#m = number of bulbs
n,m = list(map(int,input().split()))
a = list()
for i in range(n):
    temp = list(map(int,input().split()))
    for i in temp[1:len(temp)]:
        a.append(i)
if len(set(a)) == m:
    print("YES")
else :
    print("NO")