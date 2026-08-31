
# #if i<n  --> 1 <= ai <= n-i
# # i connects i and i+ai

# s = list(input())
# print(s)
# ant = 0
# hello = "hello"
# TT = False
# def f():
# 	ant = -1
# 	sol = list()

# 	for a in (hello):

# 		while(a in hello):
			
# 			i = s.index(a)
# 			if (i<ant):
# 				s.remove(a)
# 			else:
# 				sol.append(a)
# 				s.remove(a)
# 				ant = i 
# 				break
# 			if not (a in hello):
# 				break
# 	if "".join(sol) == "hello":
# 		global TT 
# 		TT= True
		
# f()

# print("YES" if TT else "NO")

vas = input().split(" ")
cand = int(vas[0])
re = int(vas[1])
ccand = cand
T=True
firsttime = True
while(T):
	
	resto = ccand%re
	ccand =ccand//re + resto
	cand+=ccand-resto
	resto = 0
	if ccand//re == 0:
		T=False
print(cand)