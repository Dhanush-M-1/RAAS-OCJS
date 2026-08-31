s = input()
ct1 = 0
ct2 = 0
ct3 = 0
for x in s :
    if x == '+' :
        continue
    if x == '1' :
        ct1 =  ct1 + 1
    else :
        if x == '2' :
            ct2 = ct2 + 1
        else :
            ct3 = ct3 + 1

ans = []
while ct1 :
    ans.append(1)
    ct1 = ct1 - 1

while ct2 :
    ans.append(2)
    ct2 = ct2 - 1

while ct3 :
    ans.append(3)
    ct3 = ct3 - 1

togo = ""
for x in range(len(ans) - 1) :
    togo = togo + (str(ans[x]) + "+")

togo = togo + (str(ans[len(ans) - 1]))
print(togo)