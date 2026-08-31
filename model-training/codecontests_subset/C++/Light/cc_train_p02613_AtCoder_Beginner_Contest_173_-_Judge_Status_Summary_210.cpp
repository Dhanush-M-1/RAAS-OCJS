#include<bits/stdc++.h>
using namespace std;
int main(){
	int n;
	cin>>n;
	int a=0,b=0,c=0,d=0;
	while(n--){
		string s;
		cin>>s;
		if(s=="AC")a++;
		else if(s=="WA")b++;
		else if(s=="TLE")c++;
		else d++;
	}
	cout<<"AC x "<<a;
	cout<<"\nWA x "<<b<<"\n";
	cout<<"TLE x "<<c<<"\n";
	cout<<"RE x "<<d;
	return 0;
}
		
