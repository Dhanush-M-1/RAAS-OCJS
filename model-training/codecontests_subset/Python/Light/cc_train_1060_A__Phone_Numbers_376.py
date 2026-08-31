n=int(input())
s=input()
cnt,ec=0,0
for i in s:
    if i=='8':
        cnt+=1
        ec+=1
    elif '0'<=i<='9':
        cnt+=1

print(min(ec,cnt//11))