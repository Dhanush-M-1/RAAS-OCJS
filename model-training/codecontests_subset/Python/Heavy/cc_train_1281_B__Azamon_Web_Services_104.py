n = int(input());
for test in range(n):
    a,B = map(str,input().split());
    a = list(a)
    b = sorted(a);
    t_rep = "";
    t_find = "";
    #print(a,b)
    for i in range(len(a)):
        if(a[i]!=b[i]):
            #a[i]=b[i];
            index=0;
            for j in range(i+1,len(a)):
                if(a[j]==b[i]):
                    index=j;
            #print(index)
            a[index]=a[i];
            a[i]=b[i];
            break;
    a = "".join(a);
    if(a<B):
        print(a)
    else:
        print("---");
                
                
    
    
