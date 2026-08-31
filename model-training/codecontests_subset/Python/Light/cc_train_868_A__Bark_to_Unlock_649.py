mumu = input().strip()
n = int(input().strip())
inputStrs = []
found = False

for i in range(n):
    inputStr = input().strip()
    if inputStr==mumu or inputStr[::-1]==mumu:
        print("YES")
        found=True
        break
    inputStrs.append(inputStr)

for i in range(n):
    if found==True:
        break
    str1 = inputStrs[i]
    for j in range(n):
        str2 = inputStrs[j]
        if str1==str2:
            continue
        str3 = str1[1]+str2[0]
        str4 = str2[1]+str1[0]
        if str3==mumu or str4==mumu:
            print("YES")
            found=True
            break

if found==False:
    print("NO")
