n,m = map(int,input().split())
stu = [list(map(int,input().split())) for i in range(n)]
chk = [list(map(int,input().split())) for i in range(m)]
for ab in stu:
  manh = [abs(ab[0]-cd[0])+abs(ab[1]-cd[1]) for cd in chk]
  print(manh.index(min(manh))+1)