n=int(input())
number=str(input())
ndiv=int(n/11)
if(n<11):
    print('0')
else:
    nume=number.count("8")
    if nume>=ndiv:
        print(ndiv)
    else :
        print(nume)