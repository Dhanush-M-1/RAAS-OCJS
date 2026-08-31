#include<iostream>
using namespace std;
int n,arr[53];
int main() {
	cin>>n;
	for(int i =1; i<=n; i++) {
		int t;
		char c;
		cin>>c>>t;
		if(c=='S')
			arr[t]++;
		else if(c=='H')
			arr[t+13]++;
		else if(c=='C')
			arr[t+26]++;
		else
			arr[t+39]++;
	}
	for(int i=1; i<=52; i++) {
		if(arr[i]==0) {
			if(i<=13)
				cout<<"S "<<i<<endl;
			else if(i<=26)
				cout<<"H "<<i-13<<endl;
			else if(i<=39)
				cout<<"C "<<i-26<<endl;
			else
				cout<<"D "<<i-39<<endl;
		}
	}
	return 0;
}
