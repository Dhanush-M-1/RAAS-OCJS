def judge(p1,p2,p3,p4):
    t1 = (p3[0] - p4[0]) * (p1[1] - p3[1]) + (p3[1] - p4[1]) * (p3[0] - p1[0])
    t2 = (p3[0] - p4[0]) * (p2[1] - p3[1]) + (p3[1] - p4[1]) * (p3[0] - p2[0])
    t3 = (p1[0] - p2[0]) * (p3[1] - p1[1]) + (p1[1] - p2[1]) * (p1[0] - p3[0])
    t4 = (p1[0] - p2[0]) * (p4[1] - p1[1]) + (p1[1] - p2[1]) * (p1[0] - p4[0])
    return t1*t2>0 and t3*t4>0 
while True:
	try:
		x1,y1,x2,y2,x3,y3,x4,y4=map(float, input().split(","))
		A=[x1,y1]
		B=[x2,y2]
		C=[x3,y3]
		D=[x4,y4]
		if judge(A,B,C,D)==False :
			print("NO")
		else:
			print("YES")
	except EOFError:
		break
