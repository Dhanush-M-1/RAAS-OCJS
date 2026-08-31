def lst(l1,l2):
    c=0
    if(len(l1)==1):
        if(l1[0] > 0 and l2[0]<=l1[0]):
            print('yes')
            return
        elif(l1[0]==0 and l2[0]==0):
            print('yes')
            return
        else:
            print('no')
            return
    for i in range(len(l1)-1):
        if((l1[i+1] > l1[i]) and (l2[i+1] >= l2[i]) and (l1[i]>=l2[i]) and (l1[i+1]-l1[i] >= l2[i+1]-l2[i])):
            c=c+1
        elif((l1[i+1]==l1[i]) and (l2[i+1]==l2[i])):
            c=c+1
    p=0
    if(l1[len(l1)-1] >= l2[len(l2)-1]):
        p=1
    if(c==len(l1)-1 and p==1):
        print('yes')
    else:
        print('no')
    return
t=int(input())
for i in range(t):
    T=int(input())
    l1=[]
    l2=[]
    for j in range(T):
        n=input()
        l = list(map(int,n.split(" ")))
        l1.append(l[0])
        l2.append(l[1])
    lst(l1,l2)