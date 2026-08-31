def main():
    expr, val = input().split(' = ')
    n = int(val)

    p = 1
    m = 0
    signs = [1]
    for ch in expr:
        if ch=='+':
            signs.append(1)
            p+=1
        elif ch=='-':
            signs.append(-1)
            m+=1

    if p-m*n>n or p*n-m<n:
        print("Impossible")
        return
    else:
        print("Possible")
        ans = [1 for i in range(len(signs))]
        if p-m<n:
            sum=abs(n-(p-m))
            # print(sum)
            for i in range(len(signs)):
                while sum>0 and signs[i]==1 and ans[i]<n:
                    ans[i]+=1
                    sum-=1

        elif p-m>n:
            sum=abs(n-(p-m))
            # print(sum)
            for i in range(len(signs)):
                while sum>0 and signs[i]==-1 and ans[i]<n:
                    ans[i]+=1
                    sum-=1




    answer = str(ans[0])
    for i in range(p+m-1):
        answer += (' + ' if signs[i+1]>0 else ' - ')
        answer += (str(ans[i+1]))

    print(answer+' = '+val)

main()