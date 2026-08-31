#include<iostream>
#include<algorithm>
using namespace std;
void sort(int A[], int C, int N){
	int c=0;
	for(int i=0;i<N-1;i++){
		if(A[i]>A[i+1]){
			swap(A[i],A[i+1]);
			c++;
		}
	}
	if(c==0) cout << C << endl;
	else{
		C+=c;
		sort(A,C,N);
	}
}

int main(){
	int n;
	while(cin >> n,n){
		int a[n],count=0;
		for(int i=0;i<n;i++) cin >> a[i];
		sort(a,count,n);
	}
}