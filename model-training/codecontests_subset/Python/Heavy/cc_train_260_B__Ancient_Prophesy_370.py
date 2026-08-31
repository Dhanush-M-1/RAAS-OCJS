s=input().rstrip()
ans=[]
p=dict()
p[1]=p[3]=p[5]=p[7]=p[8]=p[10]=p[12]=31

p[4]=p[6]=p[9]=p[11]=30
p[2]=28
for i in range(len(s)-3):
    
    if s[i:i+4]=='2013' or s[i:i+4]=='2014' or s[i:i+4]=='2015':
        #print('halua')
        if s[i-1]=='-' and s[i-2]!='-' and s[i-3]!='-' and s[i-4]=='-' and s[i-5]!='-' and  s[i-6]!='-':
            #print('hand',int(s[i-3] + s[i-2]))
            if int(s[i-3]+s[i-2])>=1 and int(s[i-3]+s[i-2])<=12:
                #print('bhadu')
                if int(s[i-6]+s[i-5])<=p[int(s[i-3]+s[i-2])] and int(s[i-6]+s[i-5])>=1:
                    ans.append(s[i-6:i+4])
#print(ans)
p=dict()
for i in ans:
    if i in p:
        p[i]+=1
    else:
        p[i]=1
mini=0
ans=''
for i in p:
    if p[i]>mini:
        mini=p[i]
        ans=i
print(ans)
        
        
        
