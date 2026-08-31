password = str(input())
start=[]
end = []
ans=0
for i in range(int(input())):
    s = str(input())
    if password in s+s:
        print("YES")
        ans=1
        break
    if password[0] in s:
        start.append(s+s)
    if password[1] in s:
        end.append(s+s)
if ans==0:
    for i in start:
        if i[-1]==password[0]:
            ans=2
            break
    if ans!=2:
        print("NO")
    else:
        for i in end:
            if i[0]==password[1]:
                ans=1
                break

        if ans==1:
            print("YES")
        else:
            print("NO")