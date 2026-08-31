t,m=map(int,input().split())
memory=[0]*m
ind=[1]
def alloc(n):
    lng=0
    for i in range(m):
        if memory[i]==0:
            lng+=1
            if lng==n:
                memory[i-lng+1:i+1]=[ind[0]]*n
                ind[0]+=1
                return ind[0]-1
        else:
            lng=0
    return "NULL"

def erase(n):
    flag=0
    for i in range(m):
        if n!=0 and memory[i]==n:
            memory[i]=0
            flag=1
    if flag==0:
        print("ILLEGAL_ERASE_ARGUMENT")
def defrag():
    offs=0
    for i in range(m):
        if offs!=0 and memory[i]!=0:
            memory[i-offs],memory[i]=memory[i],0
        elif memory[i]==0:
            offs+=1

for i in range(t):
    command=input().split()
    if len(command)==2:
        if command[0]=='alloc':
            print(alloc(int(command[1])))
        if command[0]=='erase':
            erase(int(command[1]))
    else:
        defrag()

