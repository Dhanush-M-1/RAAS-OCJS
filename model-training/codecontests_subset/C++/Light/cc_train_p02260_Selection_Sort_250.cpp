#include <iostream>
using namespace std;

int trace(int A[],int n){
	int sw=0;
	int minj=0;
	for(int i=0;i<n-1;i++){
		minj=i;
		for(int j=i;j<n;j++){
			if(A[minj]>A[j]){
					minj=j;
			}
			
		}
			swap(A[i],A[minj]);
				if(minj!=i) sw++;
	}
	return sw;
}

int main(){
	int A[100],sw,N;
	cin>>N;
	for(int i=0;i<N;i++){
		cin>>A[i];
	}
	
	sw = trace(A,N);
	
	for(int i=0;i<N;i++){
		if(i) cout<<" ";
		cout<<A[i];
	}
	cout<<endl;
	cout<<sw<<endl;
	return 0;
	
}