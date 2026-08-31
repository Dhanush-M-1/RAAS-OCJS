n=int(input())
s=input()
t=int(n/11)
if n<11:
    print("0")

else:
    p=s.count("8")
    
    if p<t:
        print(p)
    if p>=t:
        print(t)