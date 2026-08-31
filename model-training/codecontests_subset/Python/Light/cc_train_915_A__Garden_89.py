str1=input().split(' ')
str2=input().split(' ')
temp=0
for i in range(0,len(str2)):
    if int(str2[i])>temp and int(str1[1])%int(str2[i])==0:
        temp=int(str2[i])
print(int(int(str1[1])/int(temp)))