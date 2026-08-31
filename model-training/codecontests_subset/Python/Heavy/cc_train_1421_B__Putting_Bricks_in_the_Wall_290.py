for _ in range(int(input())):
    n=int(input())
    data=[]
    for q in range(n):
        data.append(input())
    start_right=data[0][1]
    start_down=data[1][0]
    end_left=data[-1][-2]
    end_top=data[-2][-1]
    if(start_right==start_down):
        if(end_left==end_top):
            if(start_down==end_left):
                ans=[[n,n-1],[n-1,n]]
            else:
                ans=[]
        else:
            if(start_down==end_left):
                ans=[[n,n-1]]
            else:
                ans=[[n-1,n]]
    else:
        if(end_left==end_top):
            if(end_top==start_down):
                ans=[[2,1]]
            else:
                ans=[[1,2]]
        else:
            if(start_down==end_top):
                ans=[[2,1],[n,n-1]]
            else:
                ans=[[2,1],[n-1,n]]
    print(len(ans))
    for q in range(len(ans)):
        print(ans[q][0],ans[q][1])