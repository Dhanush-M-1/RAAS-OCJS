n=int(input())
sr=input()
sol=0
eights=sr.count("8")
while n>=11 and eights>0:
    sol+=1
    eights-=1
    n-=11
print(sol)