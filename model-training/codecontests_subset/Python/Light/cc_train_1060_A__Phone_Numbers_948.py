n=int(input())
s=input()
e=s.count("8")
if(e<1):
    print(0)
else:
    k=len(s)//11
    print(min(k,e))