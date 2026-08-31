n=int(input())
for i in range(n):
        s=input()
        s=s.strip()
        y=s.find(" ")
        l=int(s[:y])
        r=int(s[y+1:s.rfind(" ")])
        d=int(s[s.rfind(" ")+1:])
        if(d<l):
            print(d)
        else:
            x=r//d
            k=(x+1)*d
            print(k)
    
    
