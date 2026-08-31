def isPallindrome(x):
    for i in range(0, int(len(x)/2)): 
        if x[i] != x[len(x)-i-1]:
            return False
    return True

cases = int(input())

for z in range(cases):
    mylist = [i for i in input()]
    n = len(mylist)
    string = ""
    i=0
    ans = 0
    while(i<n):
        count = 0
        x = mylist[i] 
        if(x=='@'):
            i+=1 
            continue
        #print("x is",x," i is ",i)
        while(i<n and mylist[i]==x and count<3):
            count+=1 
            i+=1 
        if(count==3):
            ans+=2 
            string = ""
        elif(count==2):
            ans+=1 
            string = ""
        else:
            i-=1
            if(i<=(n-3)):
                string = mylist[i]+mylist[i+1]+mylist[i+2]
                #print(string)
                if(isPallindrome(string)):
                    ans+=1 
                    mylist[i+2] = '@'
            i+=1    

    print(ans)   
        