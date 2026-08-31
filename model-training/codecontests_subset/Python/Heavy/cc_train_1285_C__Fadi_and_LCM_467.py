n=int(input())
if n==1:
    print (1,end=" ")
    print (1)
else:
    arr=[]
    now=n
    for  j in range(2,int(pow(n,0.5))+1):
        if  n%j==0:
            k=1
            while n%j==0:
                n=n//j
                k*=j
            arr.append(k)
    if n!=1:
        arr.append(n)
    ans=9999999999999999
    ans_1=-1
    ans_2=-1
    if len(arr)==1:
        print (1,end=" ")
        print (now)
    else:
        a=1<<len(arr)-1
        while a>0:
            p=1
            q=1
            k=a
            l=len(arr)-1
            while k>=0:
                if k&1:
                    p*=arr[l]
                    l-=1
                else:
                    q*=arr[l]
                    l-=1
                if l==-1:
                    break
                k=k>>1
            z=max(p,q)
            if ans>z:
                ans=z
                ans_1=p
                ans_2=q
            a-=1
        print (ans_1,end=" ")
        print (ans_2)