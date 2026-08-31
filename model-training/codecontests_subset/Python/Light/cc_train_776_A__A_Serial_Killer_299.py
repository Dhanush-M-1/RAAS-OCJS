
s = ' '+input()+' '
n = int(input())
print(s[1:-1])
for i in range(n):
    l,r = input().split()
    s = s.replace(' '+l+' ',' '+r+' ')
    print(s[1:-1])
