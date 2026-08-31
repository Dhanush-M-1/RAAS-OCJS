import bisect
for _ in range(int(input())):
    n,m=map(int,input().split())
    s=input()
    p=list(map(int,input().split()))
    p.sort()
    count={'a':0,'b':0,'c':0,'d':0,'e':0,'f':0,'g':0,'h':0,'i':0,'j':0,'k':0,'l':0,'m':0,'n':0,'o':0,'p':0,'q':0,'r':0,'s':0,'t':0,'u':0,'v':0,'w':0,'x':0,'y':0,'z':0}
    summ={'a':0,'b':0,'c':0,'d':0,'e':0,'f':0,'g':0,'h':0,'i':0,'j':0,'k':0,'l':0,'m':0,'n':0,'o':0,'p':0,'q':0,'r':0,'s':0,'t':0,'u':0,'v':0,'w':0,'x':0,'y':0,'z':0}

    for i in range(n):
        ind=bisect.bisect_right(p,i)
        if m-ind>0:
            summ[s[i]]+=m-ind
        count[s[i]]+=1
    for i in list(count.keys()):
        summ[i]+=count[i]
    for j in list(summ.values()):
        print(j,end=" ")
    print()
