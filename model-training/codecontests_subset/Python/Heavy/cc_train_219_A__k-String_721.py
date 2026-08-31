k = int(input())
string = input()
stringlist = list(string)
stringlist.sort()
chkr =1
iterc = []
final = []
#--------------------------------------------
letters = []
j = 1
i = 0
count = 1
#print(stringlist)
while(j < len(stringlist)):
    if(stringlist[i] == stringlist[j]):
        count += 1
    else:
        single = []
        single.append(stringlist[i])
        single.append(count)
        letters.append(single)
        count = 1
        i = j
    j += 1
single = []
single.append(stringlist[i])
single.append(count)
letters.append(single)
#print(letters)
#--------------------------------------------
for i in range(0,len(letters)):
    if(letters[i][1] % k != 0):
        chkr = 0
        break
    else:
        iterc.append(int(letters[i][1] / k))
if(chkr == 0):
    print(-1)
else:
    for j in range(0,len(letters)):
        for duri in range(0,iterc[j]):
            final.append(letters[j][0])
ans = []
for w in range(0,k):
    ans.append(''.join(final))
finalans = ''.join(ans)
print(finalans)