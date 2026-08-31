while 1:
    n=int(input())
    if n==0:break
    a=0
    s=input().split()
    for i in range(0,len(s),2):
        if i+1==len(s):break
        s[i]+=s[i+1]
        if(('lu' in s[i] and 'ru' in s[i])or('ld' in s[i] and 'rd' in s[i])):a+=1
    print(a)