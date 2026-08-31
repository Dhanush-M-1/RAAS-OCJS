n , c , b , a = map(int,input().split())

c = c//2

k=0
for i in range(a+1):

    if 2*i>n:
        break

    for j in range(b+1):

        if 2*i+j>n:

            break

        if 2*i+j+c>=n:

            k+=1

print(k)