number=int(input())
list_of_error=list(map(int,input().split()))
list_of_error_after1=list(map(int,input().split()))
list_of_error_after2=list(map(int,input().split()))

print(sum(list_of_error)- sum(list_of_error_after1))
print(sum(list_of_error_after1)- sum(list_of_error_after2))

