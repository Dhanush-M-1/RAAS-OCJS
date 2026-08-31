s=input()
f=b=False
for _ in range(int(input())):
    t=input()
    if t[0]==s[1]:
        f=True
    if t[1]==s[0]:
        b=True
    if s==t:
        f=b=True
        break
if f and b:
    print("Yes")
else:
    print("No")