#defragment functions resets the array
def defragment(a):
    b=[]
    for i in a:
        if i is not -1:
            b.append(i)
    if len(b)!=len(a):
        b=b+[-1 for i in range(len(a)-len(b))]
    return b


#erase returns array and opcode -1 if unsuccesful else 1
def erase(a,key):
    c=0
    for i in range(len(a)):
        if a[i]==key:
            c=1
            a[i]=-1  #free the space
    if c==0 or key==-1:
        return a,-1
    return a,1

# alloc takes prev identifier array and bytes to be allocated
def alloc(a,prev,byte):
    n=prev+1
    for i in range(len(a)):
        if a[i]==-1:
            j=0
            while True:
                if j==byte:
                    for k in range(byte):
                        a[i+k]=n             #allocating here
                    return a,n               #exit here
                elif i+j>len(a)-1:
                    break
                elif a[i+j]!=-1:
                    break
                else:
                    j+=1
            i=i+j
    return a,-1

def tester():
    t,m=map(int,input().split())
    a=[-1]*m
    prev=0
    for i in range(t):
        x=input()
        if x[0]=='a':
            bytes_=int(x.split(" ")[-1]) #bytes to be allocated
            a,r_t=alloc(a,prev,bytes_)
            if r_t==-1:
                print("NULL")
            else:
                print(r_t)
                prev=r_t
        elif x[0]=='e':
            i_d=int(x.split(" ")[-1]) #identifier
            a,r_t=erase(a,i_d)
            if r_t==-1:
                print("ILLEGAL_ERASE_ARGUMENT")
        elif x[0]=='d':
            a=defragment(a)
            #print(a)

tester()
