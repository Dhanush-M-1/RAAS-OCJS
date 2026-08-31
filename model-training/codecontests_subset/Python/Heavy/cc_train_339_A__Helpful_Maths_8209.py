s=input()
result=""
count1=count2=count3=0

for i in range(0,len(s),1):
    if s[i]=='1':
        count1+=1
    elif s[i]=='2':
        count2+=1
    elif s[i]=='3':
        count3+=1

while count1:
    if len(result)==len(s)-1:
        result+="1"
    else:
        result+="1+"
    count1-=1

while count2:
    if len(result)==len(s)-1:
        result+="2"
    else:
        result+="2+"
    count2-=1

while count3:
    if len(result)==len(s)-1:
        result+="3"
    else:
        result+="3+"
    count3-=1
    
print(result)
    