s=input()
l=len(s)
m=['01','02','03','04','05','06','07','08','09','10','11','12']
d=[31,28,31,30,31,30,31,31,30,31,30,31]
ans={}
for i in range(l-9):
    if s[i+2] == '-':
        if s[i+3]+s[i+4] in m:
            if s[i+5] == '-':
                if s[i+6]+s[i+7]+s[i+8]+s[i+9] in ['2013','2014','2015']:
                    if s[i] in '0123456789':
                        if s[i+1] in '0123456789':
                            if int(s[i]+s[i+1])>0 and int(s[i]+s[i+1]) <= d[int(s[i+3]+s[i+4])-1]:
                                if s[i:i+10] in ans:
                                    ans[s[i:i+10]]+=1
                                else:
                                    ans[s[i:i+10]]=1
#print(ans)
x=-1
a=None
for i in ans:
    if ans[i]>x:
        x=ans[i]
        a=i
print(a)