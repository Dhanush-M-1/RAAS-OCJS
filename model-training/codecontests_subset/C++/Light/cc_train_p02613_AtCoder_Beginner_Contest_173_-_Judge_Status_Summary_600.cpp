#include<bits/stdc++.h>
using namespace std;
int n,ac,wa,tle,re;string s;
int main(){
	cin>>n;
	while(n--){
		cin>>s;
		if(s=="AC")ac++;
		if(s=="WA")wa++;
		if(s=="TLE")tle++;
		if(s=="RE") re++;
	}
	cout<<"AC x "<<ac<<endl;
	cout<<"WA x "<<wa<<endl;
	cout<<"TLE x "<<tle<<endl;
	cout<<"RE x "<<re<<endl;
	return 0;
}