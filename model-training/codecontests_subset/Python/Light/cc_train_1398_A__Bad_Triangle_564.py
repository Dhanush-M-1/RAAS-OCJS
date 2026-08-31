t = int (input ())
inn =[]
result=[]
c=0
for j in range(t):
    n = int (input())
    inn = [int (a) for a in input().split()]
    if ((((inn[0]+inn[1])>inn[n-1]) & ((inn[0]+inn[n-1])>inn[1]) & ((inn[1]+inn[n-1])>inn[0])) &  (((inn[n-1]+inn[n-2])>inn[0]) & ((inn[n-1]+inn[0])>inn[n-2]) & ((inn[0]+inn[n-2])>inn[n-1]))):
        result.append("-1")
    else: result.append([1,2,n])
for i in result:
    if (type(i) == list):
        for j in i:
            if (c!=(len(i)-1)):
                print(j, end=' ')
                c=c+1
            else:
                print(j)
                c=0
    else:
        print(i)