#include <iostream>
using namespace std;
int main(){
	int n,b;
	bool a[53];
	char c;
	cin>>n;
	for (int i=0;i<53;i++){
		a[i]=false;
	}
	for (int i=1;i<n+1;i++){
		cin>>c>>b;
		if (c=='S')
			a[b]=true;
		else if (c=='H')
			a[b+13]=true;
		else if (c=='C')
			a[b+26]=true;
		else if (c=='D')
			a[b+39]=true;
	}
	for (int i=1;i<53;i++){
		if (i<14 && a[i]==false)
			cout<<"S "<<i<<endl;
		else if (i<27 && a[i]==false)
			cout<<"H "<<i-13<<endl;
		else if (i<40 && a[i]==false)
			cout<<"C "<<i-26<<endl;
		else if (a[i]==false)
			cout<<"D "<<i-39<<endl;
	}
}
