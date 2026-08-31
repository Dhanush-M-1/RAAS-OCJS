def game(inp):
    for item in inp:
        result = True
        for i in range(len(item)):
            if item[i][0] < item[i][1]:
                result = False
            elif i > 0:
                if item[i-1][0] > item[i][0] or item[i-1][1] > item[i][1]:
                    result = False
                if item[i][0] - item[i-1][0] < item[i][1] - item[i-1][1]:
                    result = False
        if result:
            print("YES")
        else:
            print("NO")    

t = int(input())
inp = []

for i in range(t):
    n = int(input())
    aux = []
    for j in range(n):
        n = list(map(int,input().split()))
        aux.append(n)
    inp.append(aux)


game(inp)
			 				   	       	  		 	 	 		