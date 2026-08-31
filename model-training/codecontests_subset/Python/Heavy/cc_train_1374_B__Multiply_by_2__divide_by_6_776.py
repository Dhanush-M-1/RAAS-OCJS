List=[]
T=int(input())
for _ in range(T):
    N=int(input())

    if N==1:List.append(0)
    elif N!=1:
        Count = 0
        while N!=1:
            if N%6==0 and N!=1:
                N/=6
                Count+=1
            elif N%6!=0 and N!=1:
                N*=2
                Count+=1
                if N%6==0:
                    N/=6
                    Count+=1
                else:
                    N*=2
                    List.append(-1)
                    break
            if N==1:List.append(Count)
for Content in List:print(Content)