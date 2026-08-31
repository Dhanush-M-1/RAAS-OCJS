for _ in range (int(input())) :
    n =int(input())
    diff = 0
    c =  1 
    initial_l0 = 0
    initial_l1 = 0 
    for i in range (n) :
        l= [int(x) for x in input().split()]
        if c == 1 :
            if l[0] < l[1] :
                c =  0
            if l[0] - l[1] < diff :
                c = 0
            if l[0] < initial_l0 :
                c=0 
            if l[1] < initial_l1 :
                c=0
            initial_l1 = l[1]
            initial_l0 = l[0]
        diff = l[0]-l[1]
    if c == 0 :
        print("NO")
    else :
        print("YES")