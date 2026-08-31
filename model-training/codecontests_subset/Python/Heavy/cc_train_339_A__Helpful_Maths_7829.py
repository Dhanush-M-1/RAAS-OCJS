s = input()
cnt1=0
cnt2=0
cnt3=0

for i in s:
        if i=='1':
                cnt1+=1
        elif i=='2':
                cnt2+=1
        elif i=='3':
                cnt3+=1
        # else:
        #         print(i)

for i in range(0,cnt1):
        print("1",end='')
        if i!=cnt1-1:
                print("+",end='')
if (cnt2!=0 and cnt1!=0):
        print("+",end='')
        
for i in range(0,cnt2):
        print("2",end='')
        if i!=cnt2-1:
                print("+",end='')
if (cnt3!=0 and cnt2!=0) or (cnt3!=0 and cnt1!=0 ):
        print("+",end='')
        
for i in range(0,cnt3):
        print("3",end='')
        if i!=cnt3-1:
                print("+",end='')
                
                