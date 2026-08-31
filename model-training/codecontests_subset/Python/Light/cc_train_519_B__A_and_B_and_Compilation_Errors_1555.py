n=int(input())
if 3<=n<=10**5:
    s=input().split()
    s1=input().split()
    s2=input().split()
    k=0
    k1=0
    k2=0
    for i in range(len(s)):
        k+=int(s[i])
    for i in range(len(s1)):
        k1+=int(s1[i])
    for i in range(len(s2)):
        k2+=int(s2[i])
    print(k-k1)
    print(k1-k2)
