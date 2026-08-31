x,y,z=32,13,2016
cnt=[] 
for i in range(z): 
    cnt.append([])
for i in range(z):
    for j in range(y): 
        cnt[i].append([])
for i in range(z):
    for j in range(y):
        for k in range(x):
            cnt[i][j].append(int(0))
s=input()
ansstr=''
ans=0
a=[0,31,28,31,30,31,30,31,31,30,31,30,31]
for i in range(len(s)-9):
    if(s[i].isdigit()&s[i+1].isdigit()&~s[i+2].isalnum()&s[i+3].isdigit()&s[i+4].isdigit()&~s[i+5].isalnum()&s[i+6].isdigit()&s[i+7].isdigit()&s[i+8].isdigit()&s[i+9].isdigit()):
        if(((int(s[i+6])*1000+int(s[i+7])*100+int(s[i+8])*10+int(s[i+9]))>=2013)&((int(s[i+6])*1000+int(s[i+7])*100+int(s[i+8])*10+int(s[i+9]))<=2015)):
            if(((int(s[i+3])*10+int(s[i+4]))<=12)&((int(s[i+3])*10+int(s[i+4]))>=1)):
                if(((int(s[i])*10+int(s[i+1]))<=a[(int(s[i+3])*10+int(s[i+4]))])&((int(s[i])*10+int(s[i+1]))>=1)):
                    cnt[int(s[i+6])*1000+int(s[i+7])*100+int(s[i+8])*10+int(s[i+9])][int(s[i+3])*10+int(s[i+4])][int(s[i])*10+int(s[i+1])]+=1
                    if(cnt[int(s[i+6]+s[i+7]+s[i+8]+s[i+9])][int(s[i+3]+s[i+4])][int(s[i]+s[i+1])]>ans):
                        ansstr=str(s[i]+s[i+1]+'-'+s[i+3]+s[i+4]+'-'+s[i+6]+s[i+7]+s[i+8]+s[i+9])
                        ans=cnt[int(s[i+6]+s[i+7]+s[i+8]+s[i+9])][int(s[i+3]+s[i+4])][int(s[i]+s[i+1])]
print(ansstr)

 	   	  		 	 			  	   		 		   	