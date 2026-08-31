# for s in[*open(0)][2::2]:a=s;print(s)


for s in[*open(0)][2::2]:x,y,*a,z=map(int,s.split());print(*([1,2,len(a)+3],[-1])[x+y>z])