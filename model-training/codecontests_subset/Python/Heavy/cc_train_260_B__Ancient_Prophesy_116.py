def is_number(str):
    try:
        int(str)
        return True
    except ValueError:
        return False

def solution(a,b,c):
    if 2013<=c<=2015:
        if b==2 and a<29:
            return True
        elif b in [1,3,5,7,8,10,12] and 0<a<32:
            return True
        elif b in [4,6,9,11] and 0<a<31:
            return True

s=input()
test={}


for i in range(0,len(s)-9):
    t=s[i:i+10]
    #print(t[:2],' ',t[3:5],' ',t[6:])
    if is_number(t[:2]) and is_number(t[3:5]) and is_number(t[6:]):
        #print(t,' ','ok')
        year=int(t[6:])
        month=int(t[3:5])
        day=int(t[:2])
        if solution(int(day),int(month),int(year)) and t.count('-')==2:
            if t in test:
                test[t]+=1
            else:
                test[t]=1
mx=-1
for i in test:
    if test[i] > mx:
        mx=test[i]
for i in test:
    if test[i] == mx:
        print(i)
        quit()