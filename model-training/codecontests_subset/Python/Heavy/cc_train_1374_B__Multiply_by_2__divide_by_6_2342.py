t = int(input())
for _ in range(t):
    n = int(input())
    temp = n
    threes = 0 ; twos = 0;
    while(temp%2==0):
        twos+=1
        temp/=2;
    #print(twos)
    temp = n
    while(temp%3==0):
        threes+=1
        temp/=3;
    #print(threes)
    twos_added = max(threes - twos , 0)
    
    operations = twos_added + threes;
    
    temp = n;
    temp = temp*(2**twos_added)
    #print(temp)
    while(temp%6==0):
        temp/=6

    if temp == 1:
        print(operations)
    else:
        print(-1)
        
