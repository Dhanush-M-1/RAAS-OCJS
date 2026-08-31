
def iseqi(s1, s2):
	if s1+s2 in string_dict:
		return string_dict[s1+s2]

	if len(s1) % 2 == 1:
		if s1 == s2:
			return True
			string_dict[s1+s2] = True
		else:
			string_dict[s1+s2] = False
			return False
	else:
		l = len(s1)//2
		if (iseqi(s1[:l], s2[:l]) and iseqi(s1[l:], s2[l:])) or (iseqi(s1[:l], s2[l:]) and iseqi(s1[l:], s2[:l])):
			string_dict[s1+s2] = True
			return True
		else:
			string_dict[s1+s2] = False
			return False

s1 = input()
s2 = input()
if len(s1) != len(s2):
	print("NO")
	quit()

string_dict = dict()
if iseqi(s1, s2):
	print("YES")
else:
	print("NO")