n=int(input())
s=input()
l=list(s)
cnt=l.count('8')
length=n//11
if length>= cnt:
    print(cnt)
elif length<= cnt:
    print(length)
elif length== cnt:
    print(lenght)
elif length<=1:
    print(0)
