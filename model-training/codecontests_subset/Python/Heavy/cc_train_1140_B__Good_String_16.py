for _ in range(int(input())):
    n = int(input())
    array = input()    
    i = 0
    dele = 0
    cool = 1
    done = 0
    one = 0
    two = 0
    if(array[0]=='>' or array[-1]=='<'):
        print(dele)
    else:
        i=0
        while i < len(array):
            # if(array[i]=='<'):
            #     i+=1
            #     while(array[i]=='<' an bd i < len(array)):
            #         i+=1
            #     if(i>=len(array)):
            #         break
            # one+=1
            
            while(array[i]=='<'):
                one+=1
                i+=1
            break
        # print(one)
        i=len(array)-1
        while i > -1:
            # if(array[i]=='>'):
            #     i-=1
            #     while(array[i]=='>' and i > -1):
            #         i-=1
            #     if(i<=-1):
            #         break
            # two+=1
            while(array[i]=='>'):
                two+=1
                i-=1
            break
        # print(two)
        print(min(two,one))