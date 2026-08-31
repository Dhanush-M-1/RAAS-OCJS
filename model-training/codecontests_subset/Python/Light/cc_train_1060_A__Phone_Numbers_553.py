n=int(input())
s=input()
occu_8=s.count('8')
if ((n<11) or (occu_8==0)):
    print(0) 
elif ((n//11) >= occu_8):
    print(occu_8)
else:
    print((n//11))
