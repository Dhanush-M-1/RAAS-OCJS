for _ in range(int(input())):
    l = []
    n = int(input())
    for _ in range(n):
        l.append(input())
    if (l[0][1] == '0' and l[1][0]=='0') and ((l[-1][-2] == '0' and l[-2][-1]=='0')):
        print(2)
        print(1, 2)
        print(2, 1)
    elif (l[0][1] == '1' and l[1][0]=='1') and ((l[-1][-2] == '1' and l[-2][-1]=='1')):
        print(2)
        print(1, 2)
        print(2, 1)
    elif (l[0][1] == '1' and l[1][0]=='1') and ((l[-1][-2] == '0' and l[-2][-1]=='0')):
        print(0)
        
    elif (l[0][1] == '0' and l[1][0]=='0') and ((l[-1][-2] == '1' and l[-2][-1]=='1')):
        print(0)
    
    elif (l[0][1] == '1' and l[1][0]=='0') and ((l[-1][-2] == '1' and l[-2][-1]=='1')):
        print(1)
        print(1, 2)
       
    elif (l[0][1] == '0' and l[1][0]=='1') and ((l[-1][-2] == '1' and l[-2][-1]=='1')):
        print(1)
        print(2, 1)
        
    elif (l[0][1] == '0' and l[1][0]=='1') and ((l[-1][-2] == '0' and l[-2][-1]=='0')):
        print(1)
        print(1, 2)
        
    elif (l[0][1] == '1' and l[1][0]=='0') and ((l[-1][-2] == '0' and l[-2][-1]=='0')):
        print(1)
        print(2, 1)
        
    
    
      
    elif (l[0][1] == '1' and l[1][0]=='1') and ((l[-1][-2] == '0' and l[-2][-1]=='1')):
       print(1)
       print(n-1, n)
    
    elif (l[0][1] == '1' and l[1][0]=='1') and ((l[-1][-2] == '1' and l[-2][-1]=='0')):
       print(1)
       print(n, n-1)
       

       
    elif (l[0][1] == '0' and l[1][0]=='0') and ((l[-1][-2] == '1' and l[-2][-1]=='0')):
       print(1)
       print(n-1, n)
    
    elif (l[0][1] == '0' and l[1][0]=='0') and ((l[-1][-2] == '0' and l[-2][-1]=='1')):
       print(1)
       print(n, n-1)
       
    elif (l[0][1] == '1' and l[1][0]=='0') and ((l[-1][-2] == '1' and l[-2][-1]=='0')):
       print(2)
       print(1, 2)
       print(n-1, n)
    elif (l[0][1] == '1' and l[1][0]=='0') and ((l[-1][-2] == '0' and l[-2][-1]=='1')):
       print(2)
       print(1, 2)
       print(n, n-1)
    elif (l[0][1] == '0' and l[1][0]=='1') and ((l[-1][-2] == '1' and l[-2][-1]=='0')):
       print(2)
       print(1, 2)
       print(n, n-1)
       
    elif (l[0][1] == '0' and l[1][0]=='1') and ((l[-1][-2] == '0' and l[-2][-1]=='1')):
       print(2)
       print(1, 2)
       print(n-1, n)
       
  