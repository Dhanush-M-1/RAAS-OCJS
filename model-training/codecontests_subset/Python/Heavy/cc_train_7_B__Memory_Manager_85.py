def alloc(s):
    global m;global size;
    cnt=0;
    for i in range(1,size+2):
        if(m[i]==0):
            cnt+=1;
            if(cnt==s):
                for j in range(i-cnt+1,i+1):m[j]=1;
                return [i-cnt+1,i];
        else:cnt=0;
    return [-1];

def erase(begin,end):
    global m;
    for i in range(begin,end+1):m[i]=0;
    return;

a=input().split(" ");
t=int(a[0]);size=int(a[1]);
m=[0];
b=0;
block=[0];
for i in range(1,size+1):m.append(0);
m.append(1);
while(t!=0):
    com=input().split(" ");
    if(com[0]=="alloc"):
        ret=alloc(int(com[1]));
        if(ret[0]!=-1):
            b+=1;
            ret.append(1);
            block.append(ret);
            print(b);
        else:print("NULL");
    elif(com[0]=="erase"):
        x=int(com[1]);
        if(x<=0 or x>b or block[x][2]==0):print("ILLEGAL_ERASE_ARGUMENT");
        else:
            block[x][2]=0;
            erase(block[x][0],block[x][1]);
    else:
        if(len(block)==0):continue;
        use=0;
        for i in range(1,len(block)):
            if(block[i][2]==0):continue;
            use+=block[i][1]-block[i][0]+1;
            blank=0;
            for j in range(1,block[i][0]):
                if(m[j]==0): blank+=1;
            block[i][0]-=blank;block[i][1]-=blank;
        for i in range(1,use+1):m[i]=1;
        for i in range(use+1,size+1):m[i]=0;
    t-=1;
                
        
