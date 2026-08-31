#include <bits/stdc++.h>
using namespace std;

int main() {
	int N;
	cin >>N;
	int A[N];
	for(int i=0 ; i<N ;i++){
		cin >>A[i];
	}
	int k=0;
	for(int i=0;i<N;i++){
		int minj=i;
		for(int j=i;j<N;j++){
			if(A[j]<A[minj]){
				minj =j ;
			}
		}
		if(i != minj){
			swap(A[i],A[minj]);
			k++;
		}
	}
	cout <<A[0];

	for(int i=1;i<N;i++){
		cout <<" "<<A[i];
	}
	cout <<endl<<k<<endl;
}
