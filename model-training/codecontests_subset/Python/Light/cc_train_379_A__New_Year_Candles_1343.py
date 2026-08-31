a,b = map(int,input().split())
total = 0
burned = 0
while(a>0):
    total += a
    burned += a
    a = burned//b
    burned = burned%b
print(total)

