s = input()

date_ = {1:31,2:28,3:31,4:30,5:31,6:30,7:31,8:31,9:30,10:31,11:30,12:31}
def is_Date_Correct(s):
    return (1<=int(s[3:5])<=12 and 2013<=int(s[6:])<=2015 and 1<=int(s[:2])<=date_[int(s[3:5])])

def is_dateformat(s):
    if s[2]=='-' and s[5]=='-':
        for i in range(len(s)):
            if i==2 or i==5: continue
            if s[i] == '-':
                return False;
        return True;
    return False;

i = 0
map = {}
while(i<len(s)):
    x = s[i:i+10]
    if is_dateformat(x) and is_Date_Correct(x):
        if x in map:
            map[x]+=1
        else:
            map[x]=1
        i+=8
    else: 
        i+=1
    if i+10>len(s): break

count = 0
res = ""
for i in map:
    if map[i] > count:
        res = i
        count = map[i]

print(res)
