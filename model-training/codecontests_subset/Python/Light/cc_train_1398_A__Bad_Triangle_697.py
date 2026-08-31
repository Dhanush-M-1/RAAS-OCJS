def resolve():
  N = int(input())
  for _ in range(N):
    length_of_array = int(input())
    A = [int(x) for x in input().split(" ")]
    isFound = False
    for i in range(length_of_array - 2):
      if A[i] + A[i+1] <= A[length_of_array-1]:
        isFound = True
        print(i+1, i+2, length_of_array)
        break
    if not isFound:
      print(-1)

if __name__ == "__main__":
  resolve()