n = int(input())
nums = list(map(int, input().split()))

odd, even = [], []
for i in nums:
	if i&1:
		odd.append(i)
	else:
		even.append(i)

odd.sort(reverse=True)
even.sort(reverse=True)

if abs(len(odd)-len(even))>1:
	if len(odd)>len(even):
		t = len(odd)-len(even)
		ans = sum(odd[len(odd)-t+1:])
	else:
		t = len(even)-len(odd)
		ans = sum(even[len(even)-t+1:])
else:
	ans = 0
print(ans)





# Monterey Grove apartments, San Jose

# What is the outgoing charges?
# Quiet neighbourhood. no party
# Breakdowns
# Car parking
# Utilities
# Guest policy
# Coming on june 4th, how to collect key
# Ship packages
# Crime rate
# I want away from street.

# Utilities extra(80-100),Parking (55 extra), electricity extra, internet extra 
# 50 application fee, 750 security deposit, 170 cleaning fee.


# By 24th May, June is free
# 2640, 2550(2nd floor), 2590








# SayBrook Pointe apartments, Santa Clara Saturday - 5pm PST














# Heritage Park - Sunday 12pm PST

# 2410, 120 for Utilities, Elect, internet, 2 parking spots






# Hidden lake apartments, Santa Clara
# Rent - 2895
# Utilities, electricity, internet extra. wtf?
# Car parking included.


# Vista 99 apartments, San Jose


# SVTC Open House, Sunnyvale