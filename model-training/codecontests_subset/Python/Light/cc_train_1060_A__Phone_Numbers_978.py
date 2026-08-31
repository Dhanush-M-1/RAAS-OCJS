n=int(input())
s=input()
num_eight=0
for i in range(n):
    if s[i]=='8':
        num_eight+=1
phone_num=n//11
if num_eight<=phone_num:
    print(num_eight)
else:
    print(phone_num)