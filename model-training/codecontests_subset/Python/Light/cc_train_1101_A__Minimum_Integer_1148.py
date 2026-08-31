
t=int(input())
for i in range(t):
    s=input()
    s=s.split(' ')
    for j in range(3):
        s[j]=int(s[j])
    #print(s)
    l=s[0]
    r=s[1]
    d=s[2]
    if d>=l and d<=r:
        x=r//d
        result=(x+1)*d
        print(result)
    else:
        print(d)

'''
s=input()
for i in range(len(s)):
    s[i]=int(s[i])
'''

