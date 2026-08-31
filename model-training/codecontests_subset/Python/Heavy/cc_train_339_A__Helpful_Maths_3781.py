s=input()
s1=''
s2=''
s3=''
for i in s:
    if i=='1':
        if s1=='':
            s1+=i
        else:
            s1+='+'+i
    elif i=='2':
        if s2=='':
            s2+=i
        else:
            s2+='+'+i
    elif i=='3':
        if s3=='':
            s3+=i
        else:
            s3+='+'+i
if s1=='' and s2=='':
    print(s3)
elif s1=='' and s3=='':
    print(s2)
elif s2=='' and s3=='':
    print(s1)
elif s1=='':
    print(s2+'+'+s3)
elif s2=='':
    print(s1+'+'+s3)
elif s3=='':
    print(s1+'+'+s2)
else:
    print(s1+'+'+s2+'+'+s3)
