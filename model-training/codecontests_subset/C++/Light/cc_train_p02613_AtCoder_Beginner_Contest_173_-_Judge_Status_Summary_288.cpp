#include <iostream>
using namespace std;
int n,a,t,r,w;
int main() {
	cin>>n;
	string s;
	for(int i=0;i<n;i++)
	{
		cin>> s;
		if(s=="AC")
		a++;
		if(s=="WA")
		w++;
		if(s=="TLE")
		t++;
		if(s=="RE")
		r++;
	}
	cout<<"AC x "<<a<<endl;
	cout<<"WA x "<<w<<endl;
	cout<<"TLE x "<<t<<endl;
	cout<<"RE x "<<r<<endl;
}