dictt={"a":1,"b":2,"c":3,"d":4,"e":5,"f":6,"g":7,"h":8,"i":9,"j":10,"k":11,"l":12,"m":13,"n":14,"o":15,"p":16,"q":17,"r":18,"s":19,"t":20,"u":21,"v":22,"w":23,"x":24,"y":25,"z":26}
for _ in range(int(input())):
    n,m=map(int,input().split())
    s=str(input())
    pi=list(map(int,input().split()))
    pi.append(n)
    ans=[0]*26
    li=[0]*n
    for i in pi:
        li[i-1]+=1
    for i in range(len(li)-2,-1,-1):
        li[i]=li[i]+li[i+1]
    for i in range(len(li)):
        ans[dictt[s[i]]-1]+=li[i]
    print(*ans)