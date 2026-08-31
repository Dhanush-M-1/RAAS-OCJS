ncards=int(input())
cards=input()
eightc=0
for i in cards:
    if i=="8":
        eightc+=1
    
if eightc==0:
    print(0)

else:
    if ncards<11:
        print(0)
    else:
        if ncards%11==0:
            if eightc*11>ncards:
                print(int(ncards/11))
            else:
                print(eightc)
        else:
            x=ncards
            while x%11!=0:
                x-=1
            if eightc*11>ncards:
                print(int(x/11))
            else:
                print(eightc)