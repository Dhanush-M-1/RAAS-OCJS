s=input()
n=s.split('+')
def printer(count):
    print('+'.join('1'*count[0]),end='')
    if count[1]!=0:
        if count[0]!=0:
            print('+',end='')
        print('+'.join('2'*count[1]),end='')
    if count[2]!=0:
        if count[1]!=0 or count[0]!=0:
            print('+',end='')
        print('+'.join('3'*count[2]))
count=[0,0,0]
for i in range(len(n)):
    if n[i]=='1':
        count[0]+=1
    if n[i]=='2':
        count[1]+=1
    if n[i]=='3':
        count[2]+=1
printer(count)

