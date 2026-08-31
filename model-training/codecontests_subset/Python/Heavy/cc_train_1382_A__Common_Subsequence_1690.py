t=int(input());

while t:
    n,m=[int(x) for x in input().split()];
    a=[int(x) for x in input().split()];
    b=[int(x) for x in input().split()];
    flag=0;
    if n<m:
        for num in a:
            if num in b:
                print("YES");
                print(1,num);
                flag=1;
                break;
        if not flag:
            print("NO");
    else:
        for num in b:
            if num in a:
                print("YES");
                print(1,num);
                flag=1;
                break;
        if not flag:
            print("NO");
    t-=1;
