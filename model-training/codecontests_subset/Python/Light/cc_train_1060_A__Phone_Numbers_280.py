def phone(n, string):
	maximumPhone = n//11
	numberEight = string.count('8')

	if numberEight == 0:
		return 0
	elif numberEight >= maximumPhone:
		return maximumPhone
	else:
		return numberEight

if __name__ == "__main__":
	n = int(input())
	string = input()
	print(phone(n, string))