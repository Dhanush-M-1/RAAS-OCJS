#include<iostream>
#include <string>
#include <utility>    
using namespace std;
int N,A[100],ans=0;
int main(){
 cin>>N;
 for(int f=0;f<N;f++)cin>>A[f];
 for(int i=0;i<N-1;i++){
 
	int minj = i;
     for(int j=i+1;j<N;j++){
		 if (A[j] < A[minj]){
			 minj = j;}}
			 swap(A[i],A[minj]);
			 if(A[i]!=A[minj])ans++;}
 for(int i=0;i<N-1;i++)cout<<A[i]<<" ";
 cout<<A[N-1]<<endl<<ans<<endl;
return 0;
	}
