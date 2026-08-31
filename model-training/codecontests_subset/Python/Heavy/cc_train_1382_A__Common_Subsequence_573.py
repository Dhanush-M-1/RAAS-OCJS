for testcases in range(int(input())):
    length=list(map(int,input().split()))
    str1=list(map(int,input().split()))
    str2=list(map(int,input().split()))
    flag=0
    if(length[0]>length[1]):
        for i in range(len(str1)):
            if((str1[i] in str2)!=0):
                print("YES")
                print("1",str1[i])
                flag=1
                break
    else:
        for i in range(len(str2)):
            if((str2[i] in str1)!=0):
                print("YES")
                print("1",str2[i])
                flag=1
                break
    if(flag==0):
        print("NO")