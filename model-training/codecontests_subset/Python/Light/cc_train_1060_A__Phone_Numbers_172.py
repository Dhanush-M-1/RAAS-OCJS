n=int(input())
s=list(input())
count_8=s.count('8')
total=len(s)
if len(s)<11:
    print(0)
elif count_8==0:
    print(0)
else:
    cnt=0
    for i in range(count_8):
        s.remove('8')
    s=s[::-1]
    for i in range(count_8):
        s.append('8')
    for i in range(count_8):
        if s[-1]=='8' and total>=11:
            total-=11 
            cnt+=1
            s.pop()
        else:
            break
    print(cnt)
    


    

