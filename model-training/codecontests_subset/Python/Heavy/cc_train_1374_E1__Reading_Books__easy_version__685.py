def solution():
    aLike = []
    bLike = []
    bothLike = []

    lines, k = input().strip().split()
    lines = int(lines)
    k = int(k)
    for i in range(lines):
        cost, isALike, isBLike = input().strip().split()
        cost = int(cost)
        isALike = (isALike == '1')
        isBLike = (isBLike == '1')
        if isALike and isBLike:
            bothLike.append(cost)
        elif isALike:
            aLike.append(cost)
        elif isBLike:
            bLike.append(cost)

    aLike.sort()
    bLike.sort()
    bothLike.sort()

    aLike.reverse()
    bLike.reverse()
    bothLike.reverse()

    cost = 0

    while len(bothLike) > 0 and k > 0:
        if len(aLike) > 0 and len(bLike) > 0:
            if bothLike[-1] <= aLike[-1] + bLike[-1]:
                cost += bothLike.pop()
                k -= 1
            else:
                cost += aLike.pop()
                cost += bLike.pop()
                k -= 1
        else:
            cost += bothLike.pop()
            k -= 1

    while k > 0:
        if len(aLike) > 0 and len(bLike) > 0:
            cost += aLike.pop()
            cost += bLike.pop()
            k -= 1
        else:
            return -1

    return cost

print(solution())
		  	  	    	  	 	  		 		  			