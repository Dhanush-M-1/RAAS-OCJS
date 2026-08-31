def main():

    n, k = map(int, input().split())

    vecBucks = list(map(int, input().split()))
    vecHours = []

    for i in range(n):

        vecHours.append(waterSegment(vecBucks[i], k))

    print(min(vecHours, default = -1))

def waterSegment(segValue, k):

    usedBuck = 0
    hours = 0

    while(usedBuck < k):

        usedBuck += segValue
        hours += 1

    if(usedBuck > k):

        return 10000000

    return hours

if __name__ == '__main__':
    main()
		  	       	 	    			 				   	