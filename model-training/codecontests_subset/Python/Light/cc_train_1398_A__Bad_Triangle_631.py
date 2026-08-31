def main():
  test_case = int(input())
  for i in range(test_case):
    n = int(input())
    lst = list(map(int,input().split()))
    if(lst[0] + lst[1] <= lst[n-1]):
      print("{0} {1} {2}".format(1,2,n))
    else:
      print("-1")


main()
