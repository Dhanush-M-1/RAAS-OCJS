#include <iostream>
using namespace std;

int n, a[100009], b[100009], c[300009];

int main(){
	cin>>n;
	for(int i=0;i<n;i++) {
		cin>>a[i]>>b[i];
		c[a[i]+b[i]]++;
	}
	for(int i=0;i<=250000;i++){
		c[i+1]+=(c[i]/2);
		c[i]%=2;
	}
	for(int i=0;i<=250000;i++){
		if(c[i]>=1) cout<<i<<" "<<0<<endl;
	}
	return 0;
}
