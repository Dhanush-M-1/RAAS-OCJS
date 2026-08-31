n,k=map(int,input().split())
t11=[]
t01=[]
t10=[]
for j in range(n):
    ti,ai,bi=map(int,input().split())
    if(ai==0 and bi==0):
        continue
    elif (ai==1 and bi==1):
        t11.append(ti)
    elif (ai==0 and bi==1):
        t01.append(ti)
    else:
        t10.append(ti)
lt11=len(t11)
lt10=len(t10)
lt01=len(t01)
if(lt11+min(lt10,lt01)>=k):
    #t11=sorted(t11)
    t01=sorted(t01)
    t10=sorted(t10)
    t1=t0=tot=0
    for i in range(min(lt10,lt01)):
        t11.append(t10[i]+t01[i])
    '''
    while k>0:
        k-=1
        if (t1<lt11):
            tot=tot+t11[t1]
            t1+=1
        elif (t0<lt01 and t0<lt10):
            tot+=t10[t0]+t01[t0]
            t0+=1
        else:
            print("-1");
            break
    print(tot)
    '''
    print(sum(sorted(t11)[:k]))
else:
    print("-1")

