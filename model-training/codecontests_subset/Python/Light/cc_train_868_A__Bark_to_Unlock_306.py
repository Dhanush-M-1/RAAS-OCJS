paswd=input()
start=paswd[0]
stop=paswd[1]
##begin=''
##end=''
n=int(input())
c,d=0,0
for i in range(n):
    a=input()
    if a[0]==stop:
        c=1
    if a[1]==start:
        d=1
    if a[0]==start and a[1]==stop:
        c,d=1,1
if c==d==1:
    print('YES')
if c==0 or d==0:
    print('NO')
##    begin=begin+a[0]
##    end=end+a[1]
##if (start in end) and (stop in begin):
##    print('YES')
##else:
##    print('NO')
