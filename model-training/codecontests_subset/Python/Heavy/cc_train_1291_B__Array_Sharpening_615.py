def generate1(n):
    arr1 = [i for i in range(int(n/2+1))]
    arr3 = arr1.copy()
    arr2 = [i for i in range(int(n/2)-1)]
    # print(arr1)
    # print(arr2)
    arr4 = arr2.copy()
    arr2.reverse()
    arr1.extend(arr2)
    arr3.reverse()
    arr4.extend(arr3)
    # print(arr1)
    # print(arr4)
    return arr1,arr4

def generate2(n):
    arr1 = [i for i in range(int(n/2)+1)]
    arr2 = [i for i in range(int(n/2))]
    arr2.reverse()
    arr1.extend(arr2)
    return arr1
def getResult(ai,n):
    if n==1:
        return "Yes"
    if n == 2:
        if ai[0]==0 and ai[1]==0:
            return "No"
        else:
            return "Yes"
    if n%2==0:
        bijiao1,bijiao2 = generate1(n)
        flag1= 1
        flag2 = 1
        for i in range(0,n):
            # print('case')
            if flag1==1:
                if ai[i]<bijiao1[i]:
                    flag1 = 0
            if flag2==1:
                if ai[i]<bijiao2[i]:
                  
                    flag2=0
            if flag1==0 and flag2 ==0:
                return "No"
        return "Yes"
    else:
        bijiao = generate2(n)
        # print(bijiao)
        for i in range(0,n):
            if ai[i]<bijiao[i]:
                return "No"
        return "Yes"
t = int(input())
for i in range(0,t):
    n = int(input())
    aii = input()
    ai = list(map(int,aii.split()))
    print(getResult(ai,n))