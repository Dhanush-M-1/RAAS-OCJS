import sys

for s in sys.stdin:
	pos = list(map(float, s.split(',')))
	sideB = (pos[3]-pos[1])*(pos[0]-pos[4]) - (pos[2]-pos[0])*(pos[1]-pos[5])
	sideD = (pos[7]-pos[1])*(pos[0]-pos[4]) - (pos[6]-pos[0])*(pos[1]-pos[5])
	abxcd = sideB * sideD
	sideA = (pos[1]-pos[3])*(pos[2]-pos[6]) - (pos[0]-pos[2])*(pos[3]-pos[7])
	sideC = (pos[5]-pos[3])*(pos[2]-pos[6]) - (pos[4]-pos[2])*(pos[3]-pos[7])
	cdxab = sideA * sideC

	if abxcd < 0 and cdxab < 0:
		print("YES")
	else:
		print("NO")