pssd = input()
s = []
for i in range(int(input())):
    s.append(input().strip())
#print(s)
flg=flg1=flg2 = "NO"
for data in s:
    if data == pssd:
        flg = "YES"
    if pssd[0] == data[1]:
        flg1 = "YES"
    if pssd[1] == data[0]:
        flg2 = "YES"
if flg == "YES":
    print("YES")
else:
    if flg1 == "YES" and flg2 == "YES":
        print("YES")
    else:
        print("NO")

