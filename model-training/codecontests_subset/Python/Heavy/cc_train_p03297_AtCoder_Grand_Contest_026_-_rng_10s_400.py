def gcd(a, b):
	while b:
		a, b = b, a % b
	return a

T=int(input())
Juice=[None]*T
for i in range(T):
    Juice[i]=list(map(int,input().split()))

#A最初の在庫,Bすぬけ君が買う本数,C以下の場合D追加


#A→A%B
def juicecheck(i):
    A=Juice[i][0]
    B=Juice[i][1]
    C=Juice[i][2]
    D=Juice[i][3]

    if A<B:
        print("No")
        return
    elif B>D:
        print("No")
        return
    elif B-1<=C:
        print("Yes")
        return
    else:
        x=A%B
        y=D%B
        

        z=gcd(B,D)

        if z==1 or B-(C+1)>=z or  (C+1)%z<=x%z<=(B-1)%z or ( (C+1)%z>B%z and ((C+1)%z<=x%z or x%z<B%z) ):
            print("No")
            return

        print("Yes")
        return
                
        #(x+n*y)%B==[C+1,B)となるnがあれば"No"

for i in range(T):
    juicecheck(i)
