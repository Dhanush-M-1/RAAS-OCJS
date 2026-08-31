def arr_inp():
    return [int(x) for x in input().split()]


r, c, d = [arr_inp() for i in range(3)]
C=((c[0]-d[0]+r[1])/2)
if(C!=int(C)):
    exit(print(-1))
C=int(C)
D=r[1]-C
A=d[0]-D
B=r[0]-A
arr=[A,B,C,D]
if(min(arr)<1 or max(arr)>9 or A==B or A==C or A==D or B==C or B==D or C==D ):
    exit(print(-1))
print(A,B)
print(C,D)
