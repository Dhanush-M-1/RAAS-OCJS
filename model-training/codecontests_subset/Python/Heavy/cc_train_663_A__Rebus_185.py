s = input().split("=")
v = int(s[1])
qs = s[0].split()
pos =0
neg =0
if len(qs) > 0:
    pos += 1
signs = []
for i in qs:
    if i == '+':
        pos+=1
        signs.append(1)
    else:
        if i == '-':
            neg +=1
            signs.append(0)
if pos == 0 and neg == 0 and v == 0:
    print("Possible\n= 0");
else:
    if (pos == 0 and neg == 0) or (pos*v - neg < v) or (pos - neg*v > v):
        print("Impossible")
    else:
        print("Possible")
        t = pos - neg
        print(1+max(0,min(v-1,v-t)),end=" ")
        t += max(0,min(v-1,v-t))
        for i in signs:
            if i == 0:
                print("-",end=" ")
                print(1+max(0,(min(v-1,t-v))),end=" ")
                t -= max(0,(min(v-1,t-v)))
            if i == 1:
                print("+",end=" ")
                print(1+max(0,(min(v-1,v-t))),end =" ")
                t += max(0,(min(v-1,v-t)))

        print("= " + str(v))

