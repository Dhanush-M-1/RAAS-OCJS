n=int(input())
s=input()
if s.count('8')==0 or len(s)<11:
    print(0)
elif s.count('8')>=1 and len(s)>=11:
    if s.count('8')==1 and len(s)>=11:
        print(1)
    else:
        if s.count('8')<=len(s)//11:
            print(s.count('8'))
        else:
            print(len(s)//11)
