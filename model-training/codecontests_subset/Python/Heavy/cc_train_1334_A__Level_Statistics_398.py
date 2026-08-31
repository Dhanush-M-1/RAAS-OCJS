for _ in range(int(input())):
    n=int(input())
    pr=-1
    bool=True
    cr=-1

    for _ in range(n):
        p,c=list(int(i) for i in input().split())
        if pr!=-1 and cr!=-1:
            if p>=pr and c>=cr and c<=p:

                if p-pr<c-cr:
                    bool=False
                pr=p
                cr=c

            else:
                bool=False

        else:
            pr=p
            cr=c
            #print("jsagk")
            if c>p:

                bool=False

    if bool:
        print("YES")
    else:
        print("NO")
