N,M = map(int,input().split())

students = tuple(tuple(map(int,input().split())) for _ in range(N))
checks = tuple(tuple(map(int,input().split())) for _ in range(M))

print(*(c for _,c in (min((abs(x0-x1)+abs(y0-y1),i+1)  for i,(x0,y0) in enumerate(checks)) for x1,y1 in students)), sep='\n')