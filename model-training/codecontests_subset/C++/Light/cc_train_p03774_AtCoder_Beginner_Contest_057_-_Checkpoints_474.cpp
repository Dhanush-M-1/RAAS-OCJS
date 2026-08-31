#include<bits/stdc++.h>
using namespace std;


long long X[101],Y[101],A[101],B[101];
int main(){
	long long n,m;
	cin >> n >> m;
	for(int i=0;i<n;i++){
		cin >> X[i] >> Y[i];
	}
	for(int i=0;i<m;i++){
		cin >> A[i] >> B[i];
	}
	
	
	for(int i=0;i<n;i++){
		long long a=0,sum=0,Mn=1e9;
		for(int j=0;j<m;j++){
			sum=abs(X[i]-A[j])+abs(Y[i]-B[j]);
			if(sum<Mn){
				Mn=sum;
				a=j+1;
			}
		}
		cout << a << endl;
	}
	
	
	return 0;
}