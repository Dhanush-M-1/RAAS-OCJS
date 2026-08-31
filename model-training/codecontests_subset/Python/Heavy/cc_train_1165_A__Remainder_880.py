if __name__=="__main__":
# Write the main function here
    # n x y
    [n,x,y]=list(map(int,input().split()))
    string=input()
    # Consider last x letters
    lastx=string[n-x:]
    # print(lastx)
    # Get the required string
    required=""
    for i in range(len(lastx)):
        if i==len(lastx)-y-1:
            required+='1'
        else:
            required+='0'
    # required[len(required)-y]=
    # print(required)
    # Check the different characters in required and lastx
    count=0
    for i in range(len(lastx)):
        if lastx[i]!=required[i]:
            count+=1
    print(count)
