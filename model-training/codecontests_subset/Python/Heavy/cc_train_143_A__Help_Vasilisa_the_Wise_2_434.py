def solve(r1,r2,c1,c2,d1,d2):
  cel1 = 0
  cel2 = 0
  cel3 = 0
  cel4 = 0
  res = (d1+r1-c2)
  another_res = c1+d1-r2
  if res <1 or res%2 !=0 or res//2 > 9 or res != another_res:
    print(-1)
    return
  cel1 = res //2
  if r1-cel1 >9 or r1-cel1 < 1 or cel1 == r1-cel1:
    print(-1)
    return
  cel2 = r1-cel1
  if d2 - cel2 >9 or d2-cel2 <1 or cel2 == d2-cel2 or cel1 == d2-cel2:
    print(-1)
    return
  cel3 = d2-cel2
  if r2-cel3 > 9 or r2-cel3 <1 or cel3 == r2-cel3 or cel1 == r2-cel3 or cel2 == r2-cel3:
    print(-1)
    return
  cel4 = r2-cel3
  print(cel1, cel2)
  print(cel3, cel4)

    

  
def main() :
  # n = int(input())
  # arr = list(map(int, input().split(' ')))
  arr = []
  for _ in range(3):
    i = list(map(int, input().split(' ')))
    arr += i
  solve(*arr)
main()
