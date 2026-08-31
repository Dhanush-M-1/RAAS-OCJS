l1, l2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())

def validar(box):
    if box[0] + box[1] == l1 \
    and box[2] + box[3] == l2 \
    and box[0] + box[2] == c1 \
    and box[1] + box[3] == c2 \
    and box[0] + box[3] == d1 \
    and box[1] + box[2] == d2:
        for i in range(4):
            for j in range(i+1, 4):
                if box[j] == box[i]: return False
        return True
    return False

for i in range(1, 10):
    for j in range(1, 10):
        for k in range(1, 10):
            for l in range(1, 10):

                if validar([i, j, k, l]):
                    print(f"{i} {j}\n{k} {l}\n")
                    exit(0)
print(-1)

		 				  			    	     	     	