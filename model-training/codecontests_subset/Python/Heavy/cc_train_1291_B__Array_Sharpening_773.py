import copy
t=int(input())
for j in range(t):
    n=int(input())
    b=False
    ar=[int(x) for x in input().split()]
    br=copy.deepcopy(ar)
    cr=copy.deepcopy(ar)
    dr=copy.deepcopy(ar)
    if(b==False):
        b=True
        for i in range(n):
            if(i==0):
                ar[i]=0
            else:
                if(ar[i]>ar[i-1]):
                    ar[i]=ar[i-1]+1
                else:
                    b=False
                    break
    if(b==False):
        b=True
        for i in range(n-1,-1,-1):
            if(i==n-1):
                br[i]=0
            else:
                if(br[i]>br[i+1]):
                    br[i]=br[i+1]+1
                else:
                    b=False
                    break
    if(b==False):
        b=True
        ch=False
        for i in range(n):
            if(i==0):
                cr[i]=0
            else:
                if(ch==False and cr[i]>cr[i-1]):
                    cr[i]=cr[i-1]+1
                elif(ch==True and cr[i]>=cr[i-1]):
                    cr[i]=cr[i-1]-1
                    if(cr[i]<0):
                        b=False
                        break
                elif(cr[i]<cr[i-1]):
                    ch=True
                elif(cr[i]==cr[i-1]):
                    ch=True
                    cr[i]=cr[i-1]-1
                    if(cr[i]<0):
                        b=False
                        break
                else:
                    b=False
                    break
    if(b==False):
        b=True
        ch=False
        for i in range(n-1,-1,-1):
            if(i==n-1):
                dr[i]=0
            else:
                if(ch==False and dr[i]>dr[i+1]):
                    dr[i]=dr[i+1]+1
                elif(ch==True and dr[i]>=dr[i+1]):
                    dr[i]=dr[i+1]-1
                    if(dr[i]<0):
                        b=False
                        break
                elif(dr[i]<dr[i+1]):
                    ch=True
                elif(dr[i]==dr[i+1]):
                    ch=True
                    dr[i]=dr[i+1]-1
                    if(dr[i]<0):
                        b=False
                        break
                else:
                    b=False
                    break
    if(b==False):
        print("No")
    else:
        print("Yes")
                    
