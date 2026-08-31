#include<bits/stdc++.h>
using namespace std;
int n,a,b,c,d,i;

int main(){
	cin>>n;
	string s;
	
	for(i=1;i<=n;i++){
		cin>>s;
		
		if(s=="AC") a++;
		if(s=="WA") b++;
		if(s=="TLE") c++;
		if(s=="RE") d++;
	}
	
	cout<<"AC x "<<a<<endl;
	cout<<"WA x "<<b<<endl;
	cout<<"TLE x "<<c<<endl;
	cout<<"RE x "<<d;
	
	return 0;
}