def partition(nums, low, high):
  pivot = nums[high]
  i = (low-1)
  for j in range(low, high):
    if nums[j] <= pivot:
      i = i+1
      temp = nums[i]
      nums[i] = nums[j]
      nums[j] = temp
  temp = nums[i+1]
  nums[i+1] = nums[high]
  nums[high] = temp
  return i+1

def quickSort(nums, low, high):
  if low<high:
    pi = partition(nums,low,high)
    quickSort(nums,low, pi-1)
    quickSort(nums,pi+1,high)

arrNum = input()
arr = [int(n) for n in arrNum.split('+')]
n = len(arr)
quickSort(arr,0,n-1)
s = ''
for i in range(0,n):
  if i!=n-1:
    s = s + str(arr[i]) + '+'
  else:
    s = s + str(arr[i])
print(s)