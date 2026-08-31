l3=[]
for i in range(ord('a'),ord('z')+1):
    l3.append(chr(i))
for _ in range(int(input())):
    n,m=map(int,input().split())
    s=input()
    l1=list(map(int,input().split()))
    l1.append(n)
    l2=[0]*(n+1)
    for i in range(m+1):
        l2[l1[i]]+=1
    for i in range(n-1,0,-1):
        l2[i]+=l2[i+1]
    d=dict()
    for i in range(n):
        if(s[i] in d.keys()):
            d[s[i]]+=l2[i+1]
        else:
            d[s[i]]=l2[i+1]
    for i in l3:
        if(i in d.keys()):
            print(d[i],end=" ")
        else:
            print(0,end=" ")
    print()
     
     