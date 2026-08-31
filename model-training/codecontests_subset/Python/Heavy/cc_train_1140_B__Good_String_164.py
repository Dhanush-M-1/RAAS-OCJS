for _ in range(int(input())):
    n=int(input())
    s=input()
    se=so=0
    if s.count("<")==n or s.count(">")==n:
        print(0)
        continue
    if n==1:
        print(0)
        continue
    if n==2:
        if s=="<<" or s==">>" or s=="><":
            print(0)
        else:
            print(1)
        continue
    for i in range(n):
        if s[i]==">":
            break
        else:
            so+=1
    for i in range(n):
        if s[n-i-1]=="<":
            break
        else:
            se+=1
    print(min(se,so))