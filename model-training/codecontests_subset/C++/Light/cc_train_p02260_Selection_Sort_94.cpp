#include <bits/stdc++.h>
using namespace std;
int main() {
	int N;
  cin >>N;
  int A[N];
  int count=0;
  for(int i=0;i<N;i++){
  cin>> A[i];
  }
  for(int i=0;i<N;i++){
    int minj=i;
  	for(int j=i;j<N;j++){
    	if(A[j]<A[minj]){
          minj=j;}  	
    }
    if(A[i]!=A[minj]){swap(A[i],A[minj]);count++;}       
  }
   for(int i=0;i<N-1;i++){
  cout << A[i]<<' ';
  }
  cout <<A[N-1]<<endl;
 cout <<count<<endl; 
}
