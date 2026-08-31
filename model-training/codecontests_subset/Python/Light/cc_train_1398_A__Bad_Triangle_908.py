def Solve():
        Result=[]
        c=0
        if(Arr[c]+Arr[c+1]>Arr[-1]):
                Result.append(-1)
                return Result
        else:
                Result.append(c+1)
                Result.append(c+2)
                Result.append(ArrSize)
                return Result
TestCases=int(input(""))
Results=[]
for c in range(TestCases):
        ArrSize=int(input(""))
        Arr=list(map(int,input().split()))
        Results.append(Solve())
for c in Results:
        for i in range(len(c)):
                print(c[i],end=" ")
        print("")

