s = input()
n = int(input())
wi = input()
f = wi[0]
sec = wi[1]
for i in range(n-1):
    temp = input()
    wi += temp
    f += temp[0]
    sec += temp[1]
if wi.find(s) != -1 or (f.find(s[1]) != -1 and sec.find(s[0]) != -1):
    print("YES")
else:
    print("NO")
