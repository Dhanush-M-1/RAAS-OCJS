def fun(ls,n):
    prv=ls[0]
    prv_index=0



    for i,val in enumerate(ls[1:-1]):
        i=i+1

        nxt_index=i+1
        nxt=ls[nxt_index]
        if(prv+val<=nxt):
            print(prv_index+1,i+1,nxt_index+1)
            return
        prv=val
        prv_index=i
    if(ls[0]+ls[1]<=ls[-1]):
        print(1,2,n)
        return
    print(-1)


T = int(input())
for i in range(T):
    # var=input()
    val=int(input())
    # st=input()
    # ms= list(map(int, input().split()))
    # ls= list(map(int, input().split()))
    st= list(map(int, input().split()))
    # fun(ls)
    fun(st,val)