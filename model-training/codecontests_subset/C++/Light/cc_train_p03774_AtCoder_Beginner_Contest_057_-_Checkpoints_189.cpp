#include<iostream>
#include <algorithm>
#include <math.h>
#include <stdlib.h>
#include <stdio.h>
using namespace std;
int main(){
	int N,M;
	int A[55],B[55],C[55],D[55];
	cin>>N>>M;
	for(int i=0;i<N;++i){
		cin>>A[i]>>B[i];
	}
	for(int i=0;i<M;++i){
		cin>>C[i]>>D[i];
	}
	for(int i=0;i<N;++i){
		int an=0;
		int ans=500000000;
		for(int j=0;j<M;++j){
			if(ans>abs(A[i]-C[j])+abs(B[i]-D[j])){
				an=j+1;
				ans=abs(A[i]-C[j])+abs(B[i]-D[j]);
			}

		}
		cout<<an<<endl;
	}

	return 0;
}
