for i in range(int(input())):
    a,b=map(int,input().split())
    s=input()
    p=list(map(int, input().split()))
    p.sort()
    d={0: 0, 1: 0, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0, 7: 0, 8: 0, 9: 0, 10: 0, 11: 0, 12: 0, 13: 0, 14: 0, 15: 0, 16: 0, 17: 0, 18: 0, 19: 0, 20: 0, 21: 0, 22: 0, 23: 0, 24: 0, 25: 0}
    for i in range(len(s)):
        d[ord(s[i])-97]+=1
    k=0
    for i in range(len(p)):
        w=s[k:p[i]]
        k=p[i]
        for j in w:
            d[ord(j)-97]+=(b-i)
    for i in range(26):
        print (d[i], end=" ")
    print ()
