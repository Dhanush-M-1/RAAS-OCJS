n = int(input())
# a = list(map(int,input().split()))
# l,k = map(int,input().split())

s = input()
c_o = s.count("1")
c_z = s.count("0")
if c_o != c_z:
    print (1)
    print (s)
    exit()
print (2)
print (s[0],s[1:])
exit()
current = 0
if s[0] == "1":
    c_o-=1
    current+=1
else:
    c_z-=1
    current -= 1
i = 1
while current==0 or c_o == c_z and i < n:
    if s[i] == "1":
        c_o-=1
        current+=1
    else:
        c_z-=1
        current -= 1
    i+=1

if current==0 and c_o == c_z:
    print (3)
    print (s[0],s[1:-1],s[-1])
else:
    print (2)
    print (s[:i],s[i:])
    
