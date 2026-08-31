for i in range(int(input())):
    N=int(input())
    lis=list(map(int,input().split()))
    gsb=[0]*3
    gsb[0]=1
    pointer=0
    length=len(lis)//2
    for i in range(1,length):
        
        if lis[i]==lis[i-1]:
            gsb[pointer]+=1 
        else:
            if pointer!=0 and gsb[pointer]<=gsb[0]:
                gsb[pointer]+=1
            elif pointer<2:
                pointer+=1 
                gsb[pointer]+=1
            else:
                gsb[pointer]+=1
    
    if lis[length]==lis[length-1]:
        k=length-1
        while(k>=0):
            if lis[k+1]==lis[k]:
                gsb[2]-=1
                k-=1 
            else:
                break
    if gsb[0]<gsb[1] and gsb[0]<gsb[2] and gsb[1]>0 and gsb[2]>0:
        for i in gsb:
            print(i,end=" ")
        print()
    else:
        for i in range(3):
            print(0,end=" ")
        print()