s=input()
def correct(s):
    c={2,5}
    for i in range(10):
        if i not in c:
            if s[i]=="-":
                return False
        else:
            if s[i]!="-":
                return False

###check for day
    if int(s[0:2])<32 and int(s[0:2])>0:
        pass
    else:
        return False

##check for month
    if int(s[3:5])>0 and int(s[3:5])<13:
        pass
    else:
        return False
#check for year
    y={"2013","2014","2015"}
    if s[6:] not in y:
        return False
    if s[0:2]=="31":
        m={"01","03","05","07","08","10","12"}
        if s[3:5] not in m:
            return False
    if s[3:5]=="02":
        if int(s[0:2])>28:
            return False
    return True


dict={}
n=len(s)
i=0
while i<=n-10:
    if correct(s[i:i+10])==True:
        if s[i:i+10] in dict:
            dict[s[i:i+10]]+=1
        else:
            dict[s[i:i+10]]=1
        i+=8
    else:
        i+=1
m=0
ans=None
for key,item in dict.items():
    if item>m:
        m=item
        ans=key
print(ans)