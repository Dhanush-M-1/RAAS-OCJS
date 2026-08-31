import sys


n, m = map(int, input().split(" "))
l = []
for i in range(1, m+1):
    l.append(i)

for i in range(n):
    li = list(map(int, input().split(" ")))
    li.remove(li[0])
    for i in li:
        if i in l:
            l.remove(i)
        if len(l) == 0:
            print("YES")
            sys.exit(0)
            
if(len(l) == 0):
    print("YES")
    sys.exit(0)
                
print("NO")