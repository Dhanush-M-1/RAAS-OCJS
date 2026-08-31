n=int(input())
st=input()
solution=0
eights=st.count("8")

while(n>=11 and eights>0):
	n -= 11
	eights-=1
	solution+=1

print(solution)
