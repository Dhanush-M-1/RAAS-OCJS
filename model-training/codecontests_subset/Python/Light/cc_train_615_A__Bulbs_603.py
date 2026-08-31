buttons,bulbs = map(int,input().split())
count = [0]*bulbs
lights = []
flag = 0
for i in range(buttons):
    l = list(map(int,input().split()))
    for i in range(1,len(l)):
        count[l[i]-1] = 1 
for i in range(bulbs):
    if count[i] == 0:
        print("NO")
        flag = 1
        break
if flag == 0:
    print("YES")